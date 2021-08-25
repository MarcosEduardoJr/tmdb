package com.tmdb.data.repository.artist

import android.util.Log
import com.tmdb.data.model.artist.Artist
import com.tmdb.data.model.artist.ArtistList
import com.tmdb.data.model.movie.Movie
import com.tmdb.data.model.movie.MovieList
import com.tmdb.data.model.tvshow.TvShow
import com.tmdb.data.model.tvshow.TvShowList
import com.tmdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.tmdb.data.repository.artist.datasource.ArtistLocaleDataSource
import com.tmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.tmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.tmdb.data.repository.movie.datasource.MovieLocaleDataSource
import com.tmdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.tmdb.data.repository.tvshow.datasource.TvShowLocaleDataSource
import com.tmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.tmdb.domain.repository.ArtistRepository
import com.tmdb.domain.repository.MovieRepository
import com.tmdb.domain.repository.TvShowRepository
import retrofit2.Response
import java.lang.Exception

/**
 * Created by marco on 22,August,2021
 */
class ArtistRepositoryImpl
    (
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocaleDataSource: ArtistLocaleDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newList = getTvShowsFromApi()
        artistLocaleDataSource.clearAll()
        artistLocaleDataSource.saveArtistToDB(newList)
        return newList
    }

    suspend fun getTvShowsFromApi(): List<Artist> {
        lateinit var list: List<Artist>
        try {
            val response: Response<ArtistList> = artistRemoteDataSource.getArtists()
            val body: ArtistList? = response.body()
            body?.let {
                list = body.artists!!
            }
        } catch (ex: Exception) {
            Log.i("MyTag", ex.message.toString())
        }
        return list
    }


    suspend fun getTvShowsFromDB(): List<Artist> {
        lateinit var list:   List<Artist>
        try {
            list = artistLocaleDataSource.getArtistFromDB()
        } catch (ex: Exception) {
            Log.i("MyTag", ex.message.toString())
        }
        return if (list.isNullOrEmpty()) {
            list = getTvShowsFromApi()
            artistLocaleDataSource.saveArtistToDB(list)
            list
        } else
            list
    }

    suspend fun getTvShowsFromCache(): List<Artist> {
        lateinit var list: List<Artist>
        try {
            list = artistCacheDataSource.getArtistFromCache()
        } catch (ex: Exception) {
            Log.i("MyTag", ex.message.toString())
        }
        return if (list.isNullOrEmpty()) {
            list = getTvShowsFromDB()
            artistCacheDataSource.saveArtistToCache(list)
            list
        } else
            list
    }





}