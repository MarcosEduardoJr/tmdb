package com.tmdb.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tmdb.domain.usecase.GetMoviesUseCase
import com.tmdb.domain.usecase.GetTvShowsUseCase
import com.tmdb.domain.usecase.UpdateMoviesUseCase
import com.tmdb.domain.usecase.UpdateTvShowsUseCase

/**
 * Created by marco on 23,August,2021
 */
class TvShowViewModelFactory(
    private val get: GetTvShowsUseCase,
    private val update: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      return TvShowViewModel(get,update) as T
    }
}