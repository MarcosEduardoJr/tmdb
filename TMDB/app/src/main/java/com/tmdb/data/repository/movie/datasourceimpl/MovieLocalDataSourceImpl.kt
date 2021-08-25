package com.tmdb.data.repository.movie.datasourceimpl

import com.tmdb.data.db.MovieDao
import com.tmdb.data.model.movie.Movie
import com.tmdb.data.repository.movie.datasource.MovieLocaleDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

/**
 * Created by marco on 22,August,2021
 */
class MovieLocalDataSourceImpl(
    private val movieDao: MovieDao
) : MovieLocaleDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            movieDao.deleteAllMovies()
        }
    }


}