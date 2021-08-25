package com.tmdb.presentation.di.core

import android.content.Context
import com.tmdb.presentation.di.artist.ArtistSubComponent
import com.tmdb.presentation.di.movie.MovieSubComponent
import com.tmdb.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by marco on 23,August,2021
 */
@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }

}