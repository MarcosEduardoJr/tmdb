package com.tmdb.data.repository.movie

import android.util.Log
import com.tmdb.data.model.movie.Movie
import com.tmdb.data.model.movie.MovieList
import com.tmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.tmdb.data.repository.movie.datasource.MovieLocaleDataSource
import com.tmdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.tmdb.domain.repository.MovieRepository
import retrofit2.Response
import java.lang.Exception

/**
 * Created by marco on 22,August,2021
 */
class MovieRepositoryImpl
    (
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocaleDataSource: MovieLocaleDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocaleDataSource.clearAll()
        movieLocaleDataSource.saveMoviesToDB(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response: Response<MovieList> = movieRemoteDataSource.getMovies()
            val body: MovieList? = response.body()
            body?.let {
                movieList = body.movies!!
            }
        } catch (ex: Exception) {
            Log.i("MyTag", ex.message.toString())
        }
        return movieList
    }


    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocaleDataSource.getMoviesFromDB()
        } catch (ex: Exception) {
            Log.i("MyTag", ex.message.toString())
        }
        return if (movieList.isNullOrEmpty()) {
            movieList = getMoviesFromApi()
            movieLocaleDataSource.saveMoviesToDB(movieList)
            movieList
        } else
            movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (ex: Exception) {
            Log.i("MyTag", ex.message.toString())
        }
        return if (movieList.isNullOrEmpty()) {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
            movieList
        } else
            movieList
    }

}