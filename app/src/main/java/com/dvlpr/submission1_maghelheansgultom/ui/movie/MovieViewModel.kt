package com.dvlpr.submission1_maghelheansgultom.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.MovieRepository
import com.dvlpr.submission1_maghelheansgultom.vo.Resource

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = movieRepository.getAllMovies()
}