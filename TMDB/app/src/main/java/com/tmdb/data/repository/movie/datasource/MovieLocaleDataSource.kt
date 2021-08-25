package com.tmdb.data.repository.movie.datasource

import com.tmdb.data.model.movie.Movie
import com.tmdb.data.model.movie.MovieList
import retrofit2.Response

/**
 * Created by marco on 22,August,2021
 */
interface MovieLocaleDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}