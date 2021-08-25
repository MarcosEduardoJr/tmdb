package com.tmdb.data.repository.tvshow.datasourceimpl

import com.tmdb.data.api.TMDBService
import com.tmdb.data.model.tvshow.TvShow
import com.tmdb.data.model.tvshow.TvShowList
import com.tmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

/**
 * Created by marco on 22,August,2021
 */
class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList>   = tmdbService.getPopularTvShows(apiKey)

}