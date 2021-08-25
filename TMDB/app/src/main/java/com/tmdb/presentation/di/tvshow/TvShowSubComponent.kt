package com.tmdb.presentation.di.tvshow

import com.tmdb.presentation.artist.ArtistActivity
import com.tmdb.presentation.movie.MovieActivity
import com.tmdb.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

/**
 * Created by marco on 23,August,2021
 */
@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(activity: TvShowActivity )

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}