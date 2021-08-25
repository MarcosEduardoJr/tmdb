package com.tmdb.data.repository.tvshow.datasource

import com.tmdb.data.model.tvshow.TvShow
import com.tmdb.data.model.tvshow.TvShowList
import retrofit2.Response

/**
 * Created by marco on 22,August,2021
 */
interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}