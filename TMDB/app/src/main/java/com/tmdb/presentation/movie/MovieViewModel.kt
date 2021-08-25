package com.tmdb.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tmdb.domain.usecase.GetMoviesUseCase
import com.tmdb.domain.usecase.UpdateMoviesUseCase

/**
 * Created by marco on 23,August,2021
 */
class MovieViewModel(
    private val get: GetMoviesUseCase,
    private val update: UpdateMoviesUseCase
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