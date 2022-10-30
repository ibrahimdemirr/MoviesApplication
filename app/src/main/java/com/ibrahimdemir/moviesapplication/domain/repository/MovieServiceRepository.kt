package com.ibrahimdemir.moviesapplication.domain.repository

import com.ibrahimdemir.moviesapplication.data.remote.MovieService
import javax.inject.Inject

class MovieServiceRepository @Inject constructor(private val movieService: MovieService) {
    suspend fun getMoviesList(api_key: String?, query: String?, page: Int?) =
        movieService.getMoviesList(api_key, query, page)
}