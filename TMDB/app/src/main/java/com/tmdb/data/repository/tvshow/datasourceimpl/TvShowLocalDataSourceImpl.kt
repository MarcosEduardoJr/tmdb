package com.tmdb.data.repository.tvshow.datasourceimpl

import com.tmdb.data.db.TvShowDao
import com.tmdb.data.model.tvshow.TvShow
import com.tmdb.data.repository.tvshow.datasource.TvShowLocaleDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

/**
 * Created by marco on 22,August,2021
 */
class TvShowLocalDataSourceImpl(
    private val dao: TvShowDao
) : TvShowLocaleDataSource {

    override suspend fun getTvShowFromDB(): List<TvShow> {
        return dao.getTvShows()
    }

    override suspend fun saveTvShowToDB(list: List<TvShow>) {
        CoroutineScope(IO).launch {
            dao.saveTvShows(list)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            dao.deleteAllTvShows()
        }
    }


}