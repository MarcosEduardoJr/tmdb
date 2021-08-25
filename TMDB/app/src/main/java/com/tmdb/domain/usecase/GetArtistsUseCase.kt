package com.tmdb.domain.usecase

import com.tmdb.data.model.artist.Artist
import com.tmdb.domain.repository.ArtistRepository

/**
 * Created by marco on 22,August,2021
 */
class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}