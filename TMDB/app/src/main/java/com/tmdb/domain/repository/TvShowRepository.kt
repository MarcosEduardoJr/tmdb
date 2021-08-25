package com.tmdb.domain.repository

import com.tmdb.data.model.movie.Movie
import com.tmdb.data.model.tvshow.TvShow

/**
 * Created by marco on 22,August,2021
 */
interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}