package com.tmdb.domain.repository

import com.tmdb.data.model.movie.Movie

/**
 * Created by marco on 22,August,2021
 */
interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}