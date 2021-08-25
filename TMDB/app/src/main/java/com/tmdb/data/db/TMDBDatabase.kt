package com.tmdb.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tmdb.data.model.artist.Artist
import com.tmdb.data.model.movie.Movie
import com.tmdb.data.model.tvshow.TvShow

/**
 * Created by marco on 18,August,2021
 */
@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao

}