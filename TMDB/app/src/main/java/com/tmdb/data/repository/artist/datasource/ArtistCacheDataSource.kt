package com.tmdb.data.repository.artist.datasource

import com.tmdb.data.model.artist.Artist

/**
 * Created by marco on 22,August,2021
 */
interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistToCache(movies: List<Artist>)
}