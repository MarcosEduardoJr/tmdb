package com.tmdb.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tmdb.domain.usecase.GetMoviesUseCase
import com.tmdb.domain.usecase.UpdateMoviesUseCase

/**
 * Created by marco on 23,August,2021
 */
class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      return MovieViewModel(getMoviesUseCase,updateMoviesUseCase) as T
    }
}