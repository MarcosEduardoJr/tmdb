package com.tmdb.presentation

import android.app.Application
import com.tmdb.BuildConfig
import com.tmdb.presentation.di.Injector
import com.tmdb.presentation.di.artist.ArtistSubComponent
import com.tmdb.presentation.di.core.*
import com.tmdb.presentation.di.movie.MovieSubComponent
import com.tmdb.presentation.di.tvshow.TvShowSubComponent
import dagger.internal.DaggerCollections

/**
 * Created by marco on 23,August,2021
 */
class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule((BuildConfig.API_KEY)))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}