package com.tmdb.data.repository.movie.datasourceimpl

import com.tmdb.data.model.movie.Movie
import com.tmdb.data.repository.movie.datasource.MovieCacheDataSource

/**
 * Created by marco on 22,August,2021
 */
class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

}