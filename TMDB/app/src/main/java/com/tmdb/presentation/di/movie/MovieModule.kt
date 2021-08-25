package com.tmdb.presentation.di.movie

import com.tmdb.domain.usecase.GetArtistsUseCase
import com.tmdb.domain.usecase.GetMoviesUseCase
import com.tmdb.domain.usecase.UpdateArtistsUseCase
import com.tmdb.domain.usecase.UpdateMoviesUseCase
import com.tmdb.presentation.artist.ArtistViewModelFactory
import com.tmdb.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by marco on 23,August,2021
 */
@Module
class MovieModule {
    @MovieScope
    @Provides
    fun proveMovieViewModelFactory(
        get: GetMoviesUseCase,
        update: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            get, update
        )
    }
}