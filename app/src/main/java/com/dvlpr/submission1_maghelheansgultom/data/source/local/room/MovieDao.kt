package com.dvlpr.submission1_maghelheansgultom.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import androidx.paging.DataSource

@Dao
interface MovieDao {
    @Query("SELECT * FROM movieentities")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities where favorite = 1")
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getMovieDetail(movieId: String): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("SELECT * FROM tvshowentities")
    fun getTvShows(): DataSource.Factory<Int, TVShowsEntity>

    @Query("SELECT * FROM tvshowentities where favorite = 1")
    fun getFavoriteTvShow(): DataSource.Factory<Int, TVShowsEntity>

    @Transaction
    @Query("SELECT * FROM tvshowentities WHERE tvShowId = :tvShowId")
    fun getTvShowDetail(tvShowId: String): LiveData<TVShowsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: List<TVShowsEntity>)

    @Update
    fun updateTvShow(tvShow: TVShowsEntity)
}