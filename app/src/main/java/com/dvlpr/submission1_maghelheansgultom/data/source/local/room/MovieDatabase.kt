package com.dvlpr.submission1_maghelheansgultom.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity

@Database(entities = [MovieEntity::class, TVShowsEntity::class],
        version = 1,
        exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var instance: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase =
            instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "Movie.db"
                ).build().apply {
                    instance = this
                }
            }
    }
}