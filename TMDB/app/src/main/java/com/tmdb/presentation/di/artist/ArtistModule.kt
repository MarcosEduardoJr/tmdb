package com.tmdb.presentation.di.artist

import com.tmdb.domain.usecase.GetArtistsUseCase
import com.tmdb.domain.usecase.UpdateArtistsUseCase
import com.tmdb.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by marco on 23,August,2021
 */
@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun proveArtistViewModelFactory(
        get: GetArtistsUseCase,
        update: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            get, update
        )
    }
}