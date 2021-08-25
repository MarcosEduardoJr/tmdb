package com.tmdb.domain.repository

import com.tmdb.data.model.artist.Artist
import com.tmdb.data.model.movie.Movie
import com.tmdb.data.model.tvshow.TvShow

/**
 * Created by marco on 22,August,2021
 */
interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}