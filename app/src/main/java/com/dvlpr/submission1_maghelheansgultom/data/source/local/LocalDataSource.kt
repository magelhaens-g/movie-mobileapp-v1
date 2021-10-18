package com.dvlpr.submission1_maghelheansgultom.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.local.room.MovieDao

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {
    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            instance ?: LocalDataSource(movieDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getMovies()

    fun getAllTvShows(): DataSource.Factory<Int, TVShowsEntity> = mMovieDao.getTvShows()

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getFavoriteMovie()

    fun getFavoriteTvShow(): DataSource.Factory<Int, TVShowsEntity> = mMovieDao.getFavoriteTvShow()

    fun getMovieDetail(movieId: String): LiveData<MovieEntity> = mMovieDao.getMovieDetail(movieId)

    fun getTvShowDetail(tvShowId: String): LiveData<TVShowsEntity> = mMovieDao.getTvShowDetail(tvShowId)

    fun insertMovie(movie: List<MovieEntity>) = mMovieDao.insertMovie(movie)

    fun insertTvShow(tvShow: List<TVShowsEntity>) = mMovieDao.insertTvShow(tvShow)

    fun setMovieFavorite(movie: MovieEntity, state: Boolean) {
        movie.favorite = state
        mMovieDao.updateMovie(movie)
    }

    fun setTvShowFavorite(tvShow: TVShowsEntity, state: Boolean) {
        tvShow.favorite = state
        mMovieDao.updateTvShow(tvShow)
    }
}