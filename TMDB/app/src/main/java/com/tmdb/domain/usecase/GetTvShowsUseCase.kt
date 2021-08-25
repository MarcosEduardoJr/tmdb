package com.tmdb.domain.usecase

import com.tmdb.data.model.tvshow.TvShow
import com.tmdb.domain.repository.TvShowRepository

/**
 * Created by marco on 22,August,2021
 */
class GetTvShowsUseCase(private val tvShowsRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowsRepository.getTvShows()
}