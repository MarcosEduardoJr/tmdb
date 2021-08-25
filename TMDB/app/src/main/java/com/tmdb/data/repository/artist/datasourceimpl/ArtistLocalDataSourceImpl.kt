package com.tmdb.data.repository.artist.datasourceimpl

import com.tmdb.data.db.ArtistDao
import com.tmdb.data.model.artist.Artist
import com.tmdb.data.repository.artist.datasource.ArtistLocaleDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

/**
 * Created by marco on 22,August,2021
 */
class ArtistLocalDataSourceImpl(
    private val dao: ArtistDao
) : ArtistLocaleDataSource {

    override suspend fun getArtistFromDB(): List<Artist> {
        return dao.getArtists()
    }


    override suspend fun saveArtistToDB(list: List<Artist>) {
        CoroutineScope(IO).launch {
            dao.saveArtists(list)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            dao.deleteAllArtists()
        }
    }


}