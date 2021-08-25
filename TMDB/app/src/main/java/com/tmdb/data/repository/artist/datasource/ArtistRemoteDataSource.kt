package com.tmdb.data.repository.artist.datasource

import com.tmdb.data.model.artist.ArtistList
import com.tmdb.data.model.tvshow.TvShow
import com.tmdb.data.model.tvshow.TvShowList
import retrofit2.Response

/**
 * Created by marco on 22,August,2021
 */
interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}