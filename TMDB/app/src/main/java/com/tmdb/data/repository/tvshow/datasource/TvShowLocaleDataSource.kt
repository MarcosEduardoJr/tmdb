package com.tmdb.data.repository.tvshow.datasource

import com.tmdb.data.model.tvshow.TvShow

/**
 * Created by marco on 22,August,2021
 */
interface TvShowLocaleDataSource {
    suspend fun getTvShowFromDB(): List<TvShow>
    suspend fun saveTvShowToDB(movies: List<TvShow>)
    suspend fun clearAll()
}