package com.tmdb.data.repository.movie.datasourceimpl

import com.tmdb.data.api.TMDBService
import com.tmdb.data.model.movie.MovieList
import com.tmdb.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

/**
 * Created by marco on 22,August,2021
 */
class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)


}