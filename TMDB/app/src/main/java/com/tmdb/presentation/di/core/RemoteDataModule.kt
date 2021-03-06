package com.tmdb.presentation.di.core

import com.tmdb.data.api.TMDBService
import com.tmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.tmdb.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.tmdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.tmdb.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.tmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.tmdb.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by marco on 23,August,2021
 */
@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}