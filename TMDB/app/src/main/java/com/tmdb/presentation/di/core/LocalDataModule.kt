package com.tmdb.presentation.di.core

import com.tmdb.data.db.ArtistDao
import com.tmdb.data.db.MovieDao
import com.tmdb.data.db.TvShowDao
import com.tmdb.data.repository.artist.datasource.ArtistLocaleDataSource
import com.tmdb.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.tmdb.data.repository.movie.datasource.MovieLocaleDataSource
import com.tmdb.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.tmdb.data.repository.tvshow.datasource.TvShowLocaleDataSource
import com.tmdb.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by marco on 23,August,2021
 */
@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(dao: MovieDao): MovieLocaleDataSource {
        return MovieLocalDataSourceImpl(dao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(dao: TvShowDao): TvShowLocaleDataSource {
        return TvShowLocalDataSourceImpl(dao)
    }


    @Singleton
    @Provides
    fun provideArtistLocalDataSource(dao: ArtistDao): ArtistLocaleDataSource {
        return ArtistLocalDataSourceImpl(dao)
    }
}