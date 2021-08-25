package com.tmdb.presentation.di.core

import com.tmdb.domain.repository.ArtistRepository
import com.tmdb.domain.repository.MovieRepository
import com.tmdb.domain.repository.TvShowRepository
import com.tmdb.domain.usecase.*
import dagger.Module
import dagger.Provides

/**
 * Created by marco on 23,August,2021
 */
@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(repository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(repository)
    }

    @Provides
    fun provideUpdateMovieUseCase(repository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(repository)
    }


    @Provides
    fun provideGetTvShowUseCase(repository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(repository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(repository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(repository)
    }


    @Provides
    fun provideGetArtistUseCase(repository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(repository)
    }

    @Provides
    fun provideUpdateArtistUseCase(repository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(repository)
    }


}