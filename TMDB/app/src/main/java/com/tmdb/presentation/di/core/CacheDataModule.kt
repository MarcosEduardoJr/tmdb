package com.tmdb.presentation.di.core

import com.tmdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.tmdb.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.tmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.tmdb.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.tmdb.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by marco on 23,August,2021
 */
@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun proveMovieCacheDataSource(): MovieCacheDataSource{
     return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun proveTvShowCacheDataSource(): TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }


    @Singleton
    @Provides
    fun proveArtistCacheDataSource(): ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }
}