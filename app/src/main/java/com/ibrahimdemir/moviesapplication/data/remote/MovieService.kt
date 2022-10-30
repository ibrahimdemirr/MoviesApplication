package com.ibrahimdemir.moviesapplication.data.remote

import com.ibrahimdemir.moviesapplication.data.model.MovieSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("search/movie")
    suspend fun getMoviesList(
        @Query("api_key") api_key: String?,
        @Query("query") query: String?,
        @Query("page") page: Int?
    ): MovieSearchResponse
}