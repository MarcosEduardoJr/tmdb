package com.tmdb.presentation.di.core

import com.tmdb.data.repository.artist.ArtistRepositoryImpl
import com.tmdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.tmdb.data.repository.artist.datasource.ArtistLocaleDataSource
import com.tmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.tmdb.data.repository.movie.MovieRepositoryImpl
import com.tmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.tmdb.data.repository.movie.datasource.MovieLocaleDataSource
import com.tmdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.tmdb.data.repository.tvshow.TvShowRepositoryImpl
import com.tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.tmdb.data.repository.tvshow.datasource.TvShowLocaleDataSource
import com.tmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.tmdb.domain.repository.ArtistRepository
import com.tmdb.domain.repository.MovieRepository
import com.tmdb.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by marco on 23,August,2021
 */
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(
        remote: MovieRemoteDataSource,
        local: MovieLocaleDataSource,
        cache: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            remote,
            local,
            cache
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        remote: ArtistRemoteDataSource,
        local: ArtistLocaleDataSource,
        cache: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            remote,
            local,
            cache
        )
    }


    @Provides
    @Singleton
    fun provideTvShowRepository(
        remote: TvShowRemoteDataSource,
        local: TvShowLocaleDataSource,
        cache: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            remote,
            local,
            cache
        )
    }
}