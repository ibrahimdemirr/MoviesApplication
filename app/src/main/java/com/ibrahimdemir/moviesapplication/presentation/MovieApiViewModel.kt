package com.ibrahimdemir.moviesapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimdemir.moviesapplication.data.model.MovieSearchResponse
import com.ibrahimdemir.moviesapplication.data.model.NetworkResult
import com.ibrahimdemir.moviesapplication.domain.usecase.GetMoviesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieApiViewModel @Inject constructor(
    private val getMoviesListUseCase: GetMoviesListUseCase
) : ViewModel() {

    private val _getMoviesList = MutableStateFlow<NetworkResult<MovieSearchResponse>?>(null)
    val getMoviesList: StateFlow<NetworkResult<MovieSearchResponse>?> = _getMoviesList

    fun getMoviesList(api_key: String?, query: String?, page: Int?) = viewModelScope.launch {
        getMoviesListUseCase.invoke(api_key, query, page).collect {
            _getMoviesList.value = it
        }
    }
}