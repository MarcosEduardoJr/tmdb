package com.tmdb.data.repository.tvshow.datasourceimpl

import com.tmdb.data.model.tvshow.TvShow
import com.tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource

/**
 * Created by marco on 22,August,2021
 */
class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvshowList = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvshowList
    }

    override suspend fun saveTvShowToCache(movies: List<TvShow>) {
        tvshowList.clear()
        tvshowList = ArrayList(movies)
    }

}