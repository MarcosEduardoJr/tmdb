package com.tmdb.data.repository.tvshow

import android.util.Log
import com.tmdb.data.model.movie.Movie
import com.tmdb.data.model.movie.MovieList
import com.tmdb.data.model.tvshow.TvShow
import com.tmdb.data.model.tvshow.TvShowList
import com.tmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.tmdb.data.repository.movie.datasource.MovieLocaleDataSource
import com.tmdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.tmdb.data.repository.tvshow.datasource.TvShowLocaleDataSource
import com.tmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.tmdb.domain.repository.MovieRepository
import com.tmdb.domain.repository.TvShowRepository
import retrofit2.Response
import java.lang.Exception

/**
 * Created by marco on 22,August,2021
 */
class TvShowRepositoryImpl
    (
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocaleDataSource: TvShowLocaleDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newList = getTvShowsFromApi()
        tvShowLocaleDataSource.clearAll()
        tvShowLocaleDataSource.saveTvShowToDB(newList)
        return newList
    }

    suspend fun getTvShowsFromApi(): List<TvShow> {
        lateinit var list: List<TvShow>
        try {
            val response: Response<TvShowList> = tvShowRemoteDataSource.getTvShows()
            val body: TvShowList? = response.body()
            body?.let {
                list = body.tvShows!!
            }
        } catch (ex: Exception) {
            Log.i("MyTag", ex.message.toString())
        }
        return list
    }


    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var list:   List<TvShow>
        try {
            list = tvShowLocaleDataSource.getTvShowFromDB()
        } catch (ex: Exception) {
            Log.i("MyTag", ex.message.toString())
        }
        return if (list.isNullOrEmpty()) {
            list = getTvShowsFromApi()
            tvShowLocaleDataSource.saveTvShowToDB(list)
            list
        } else
            list
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var list: List<TvShow>
        try {
            list = tvShowCacheDataSource.getTvShowFromCache()
        } catch (ex: Exception) {
            Log.i("MyTag", ex.message.toString())
        }
        return if (list.isNullOrEmpty()) {
            list = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowToCache(list)
            list
        } else
            list
    }

}