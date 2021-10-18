package com.dvlpr.submission1_maghelheansgultom.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dvlpr.submission1_maghelheansgultom.data.source.MovieRepository
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity

class FavTvShowViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getFavoriteTvShow(): LiveData<PagedList<TVShowsEntity>> = movieRepository.getFavoriteTvShow()
}