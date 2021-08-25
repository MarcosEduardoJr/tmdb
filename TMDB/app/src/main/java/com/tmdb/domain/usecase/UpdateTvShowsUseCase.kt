package com.tmdb.domain.usecase

import com.tmdb.data.model.tvshow.TvShow
import com.tmdb.domain.repository.TvShowRepository

/**
 * Created by marco on 22,August,2021
 */
class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}