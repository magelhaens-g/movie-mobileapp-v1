package com.dvlpr.submission1_maghelheansgultom.di

import android.content.Context
import com.dvlpr.submission1_maghelheansgultom.data.source.MovieRepository
import com.dvlpr.submission1_maghelheansgultom.data.source.local.LocalDataSource
import com.dvlpr.submission1_maghelheansgultom.data.source.local.room.MovieDatabase
import com.dvlpr.submission1_maghelheansgultom.data.source.remote.RemoteDataSource
import com.dvlpr.submission1_maghelheansgultom.utils.AppExecutors
import com.dvlpr.submission1_maghelheansgultom.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieRepository {
        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}