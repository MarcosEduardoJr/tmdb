package com.tmdb.data.repository.artist.datasourceimpl

import com.tmdb.data.model.artist.Artist
import com.tmdb.data.model.tvshow.TvShow
import com.tmdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource

/**
 * Created by marco on 22,August,2021
 */
class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var list = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return list
    }

    override suspend fun saveArtistToCache(movies: List<Artist>) {
        list.clear()
        list = ArrayList(movies)
    }

}