package com.dvlpr.submission1_maghelheansgultom.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.MovieRepository
import com.dvlpr.submission1_maghelheansgultom.vo.Resource

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    val movieId = MutableLiveData<String>()
    val tvShowId = MutableLiveData<String>()

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId.value = tvShowId
    }

    var movieDetail: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mMovieId ->
        movieRepository.getDetailMovie(mMovieId)
    }

    var tvShowDetail: LiveData<Resource<TVShowsEntity>> = Transformations.switchMap(tvShowId) { mTvShowId ->
        movieRepository.getDetailTvShow(mTvShowId)
    }

    fun setMovieFavorite() {
        val detail = movieDetail.value?.data
        if (detail != null) {
            val newState = !detail.favorite
            movieRepository.setFavoriteMovie(detail, newState)
        }
    }

    fun setTvShowFavorite() {
        val detail = tvShowDetail.value?.data
        if (detail != null) {
            val newState = !detail.favorite
            movieRepository.setFavoriteTvShow(detail, newState)
        }
    }
}