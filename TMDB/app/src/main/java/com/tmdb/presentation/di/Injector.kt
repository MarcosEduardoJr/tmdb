package com.tmdb.presentation.di

import com.tmdb.presentation.di.artist.ArtistSubComponent
import com.tmdb.presentation.di.movie.MovieSubComponent
import com.tmdb.presentation.di.tvshow.TvShowSubComponent

/**
 * Created by marco on 23,August,2021
 */
interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}