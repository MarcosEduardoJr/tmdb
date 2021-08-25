package com.tmdb.presentation.di.tvshow

import com.tmdb.domain.usecase.GetArtistsUseCase
import com.tmdb.domain.usecase.GetTvShowsUseCase
import com.tmdb.domain.usecase.UpdateArtistsUseCase
import com.tmdb.domain.usecase.UpdateTvShowsUseCase
import com.tmdb.presentation.artist.ArtistViewModelFactory
import com.tmdb.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by marco on 23,August,2021
 */
@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun proveTvShowViewModelFactory(
        get: GetTvShowsUseCase,
        update: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            get, update
        )
    }
}