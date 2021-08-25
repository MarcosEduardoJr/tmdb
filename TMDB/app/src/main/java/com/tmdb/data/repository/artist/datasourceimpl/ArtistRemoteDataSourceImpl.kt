package com.tmdb.data.repository.artist.datasourceimpl

import com.tmdb.data.api.TMDBService
import com.tmdb.data.model.artist.ArtistList
import com.tmdb.data.model.tvshow.TvShow
import com.tmdb.data.model.tvshow.TvShowList
import com.tmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.tmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

/**
 * Created by marco on 22,August,2021
 */
class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList>  =  tmdbService.getPopularArtists(apiKey)

}