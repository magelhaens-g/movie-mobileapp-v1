package com.dvlpr.submission1_maghelheansgultom.ui.tvShow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.MovieRepository
import com.dvlpr.submission1_maghelheansgultom.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TVShowsEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TVShowsEntity>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(movieRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShows = Resource.success(pagedList)
        `when`(dummyTvShows.data?.size).thenReturn(10)
        val tvShow = MutableLiveData<Resource<PagedList<TVShowsEntity>>>()
        tvShow.value = dummyTvShows
        `when`(movieRepository.getAllTvShows()).thenReturn(tvShow)
        val tvShowEntites = viewModel.getTvShows().value?.data
        verify(movieRepository).getAllTvShows()
        assertNotNull(tvShow)
        assertEquals(10, tvShowEntites?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}