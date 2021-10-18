package com.dvlpr.submission1_maghelheansgultom.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dvlpr.submission1_maghelheansgultom.data.source.MovieRepository
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity

class FavMovieViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> = movieRepository.getFavoriteMovie()
}