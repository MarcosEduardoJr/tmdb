package com.tmdb.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tmdb.domain.usecase.*

/**
 * Created by marco on 23,August,2021
 */
class ArtistViewModelFactory(
    private val get: GetArtistsUseCase,
    private val update: UpdateArtistsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      return ArtistViewModel(get,update) as T
    }
}