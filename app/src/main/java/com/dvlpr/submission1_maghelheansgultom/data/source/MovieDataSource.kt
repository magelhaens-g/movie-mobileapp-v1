package com.dvlpr.submission1_maghelheansgultom.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import com.dvlpr.submission1_maghelheansgultom.vo.Resource

interface MovieDataSource {
    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllTvShows(): LiveData<Resource<PagedList<TVShowsEntity>>>

    fun getDetailMovie(movieId: String): LiveData<Resource<MovieEntity>>

    fun getDetailTvShow(tvShowId: String): LiveData<Resource<TVShowsEntity>>

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteTvShow(): LiveData<PagedList<TVShowsEntity>>

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun setFavoriteTvShow(tvShow: TVShowsEntity, state: Boolean)
}