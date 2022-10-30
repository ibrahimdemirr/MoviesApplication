package com.ibrahimdemir.moviesapplication.data.model

sealed class NetworkResult<T> {
    data class Loading<T>(val isLoading: Boolean) : NetworkResult<T>()
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error<T>(var exception: Throwable) : NetworkResult<T>()
}