package com.tmdb.domain.usecase

import com.tmdb.data.model.movie.Movie
import com.tmdb.domain.repository.MovieRepository

/**
 * Created by marco on 22,August,2021
 */
class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}