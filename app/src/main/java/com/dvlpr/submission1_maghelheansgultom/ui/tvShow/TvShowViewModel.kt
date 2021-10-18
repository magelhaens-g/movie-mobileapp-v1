package com.dvlpr.submission1_maghelheansgultom.ui.tvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.MovieRepository
import com.dvlpr.submission1_maghelheansgultom.vo.Resource

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getTvShows(): LiveData<Resource<PagedList<TVShowsEntity>>> = movieRepository.getAllTvShows()
}