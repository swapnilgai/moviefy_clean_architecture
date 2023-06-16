package com.example.moviefy_clean_architecture.network.module

import retrofit2.http.GET
import retrofit2.http.QueryMap
import com.example.moviefy_clean_architecture.network.module.model.Result

interface GetMoviesService {
    // Get Upcoming movies
    @GET("movie/upcoming")
    suspend fun getUpcomingMovieList(@QueryMap map: Map<String?, String?>?): Result?

    // Get top rated movies
    @GET("movie/top_rated")
    suspend fun getTopRatedMovieList(@QueryMap map: Map<String?, String?>?): Result?

    ///Get Now playing movies
    @GET("movie/now_playing")
    suspend fun getNoePlayingMovielist(@QueryMap map: Map<String?, String?>?): Result?

    //@Get popular movies
    @GET("movie/popular")
    suspend fun getPopularMovieList(@QueryMap map: Map<String?, String?>?): Result?

    // Get top rated tv show
    @GET("tv/popular")
    suspend fun getPopularTvShows(@QueryMap map: Map<String?, String?>?): Result

    // Get top rated tv show
    @GET("tv/top_rated")
    suspend fun getTopRatedTvShow(@QueryMap map: Map<String?, String?>?): Result
}