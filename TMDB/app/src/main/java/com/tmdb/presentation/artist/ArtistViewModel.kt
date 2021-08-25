package com.tmdb.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tmdb.domain.usecase.*

/**
 * Created by marco on 23,August,2021
 */
class ArtistViewModel(
    private val get: GetArtistsUseCase,
    private val update: UpdateArtistsUseCase
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