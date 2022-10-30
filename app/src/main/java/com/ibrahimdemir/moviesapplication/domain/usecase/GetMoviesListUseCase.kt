package com.ibrahimdemir.moviesapplication.domain.usecase

import com.ibrahimdemir.moviesapplication.data.model.NetworkResult
import com.ibrahimdemir.moviesapplication.domain.repository.MovieServiceRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMoviesListUseCase @Inject constructor(private val movieServiceRepository: MovieServiceRepository) {
    suspend operator fun invoke(api_key: String?, query: String?, page: Int?) = flow {
        try {
            emit(NetworkResult.Loading(true))
            emit(NetworkResult.Success(movieServiceRepository.getMoviesList(api_key, query, page)))
        } catch (exception: Exception) {
            emit(NetworkResult.Error(exception))
        }
    }
}