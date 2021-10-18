package com.dvlpr.submission1_maghelheansgultom.ui.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dvlpr.submission1_maghelheansgultom.data.source.MovieRepository
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavTvShowViewModelTest {
    private lateinit var viewModel: FavTvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TVShowsEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TVShowsEntity>

    @Before
    fun setUp() {
        viewModel = FavTvShowViewModel(movieRepository)
    }

    @Test
    fun getFavoriteTvShow() {
        val dummyFavoriteTvShow = pagedList
        Mockito.`when`(dummyFavoriteTvShow.size).thenReturn(10)
        val favoriteTvShow = MutableLiveData<PagedList<TVShowsEntity>>()
        favoriteTvShow.value = dummyFavoriteTvShow
        Mockito.`when`(movieRepository.getFavoriteTvShow()).thenReturn(favoriteTvShow)
        val tvShowEntities = viewModel.getFavoriteTvShow().value
        verify(movieRepository).getFavoriteTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getFavoriteTvShow().observeForever(observer)
        verify(observer).onChanged(dummyFavoriteTvShow)
    }
}