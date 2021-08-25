package com.tmdb.presentation.di.artist

import com.tmdb.presentation.artist.ArtistActivity
import dagger.Subcomponent

/**
 * Created by marco on 23,August,2021
 */
@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }
}