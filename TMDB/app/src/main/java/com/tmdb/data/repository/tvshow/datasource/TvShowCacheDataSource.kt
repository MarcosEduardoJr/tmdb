package com.tmdb.data.repository.tvshow.datasource

import com.tmdb.data.model.tvshow.TvShow

/**
 * Created by marco on 22,August,2021
 */
interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowToCache(movies: List<TvShow>)
}