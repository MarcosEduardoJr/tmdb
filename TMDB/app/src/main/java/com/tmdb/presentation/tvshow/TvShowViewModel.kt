package com.tmdb.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tmdb.domain.usecase.GetMoviesUseCase
import com.tmdb.domain.usecase.GetTvShowsUseCase
import com.tmdb.domain.usecase.UpdateMoviesUseCase
import com.tmdb.domain.usecase.UpdateTvShowsUseCase

/**
 * Created by marco on 23,August,2021
 */
class TvShowViewModel(
    private val get: GetTvShowsUseCase,
    private val update: UpdateTvShowsUseCase
) : ViewModel() {
    fun get() = liveData {
        val movieList = get.execute()
        emit(movieList)
    }

    fun update() = liveData {
        val movieList = update.execute()
        emit(movieList)
    }
}