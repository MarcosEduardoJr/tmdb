package com.tmdb.presentation.di.movie

import com.tmdb.presentation.artist.ArtistActivity
import com.tmdb.presentation.movie.MovieActivity
import dagger.Subcomponent

/**
 * Created by marco on 23,August,2021
 */
@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(activity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}