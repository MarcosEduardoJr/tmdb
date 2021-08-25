package com.tmdb.data.repository.artist.datasource

import com.tmdb.data.model.artist.Artist

/**
 * Created by marco on 22,August,2021
 */
interface ArtistLocaleDataSource {
    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(movies: List<Artist>)
    suspend fun clearAll()
}