package com.dvlpr.submission1_maghelheansgultom.ui.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dvlpr.submission1_maghelheansgultom.data.source.MovieRepository
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavMovieViewModelTest {
    private lateinit var viewModel: FavMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavMovieViewModel(movieRepository)
    }

    @Test
    fun getFavoriteMovie() {
        val dummyFavoriteMovie = pagedList
        `when`(dummyFavoriteMovie.size).thenReturn(10)
        val favoriteMovie = MutableLiveData<PagedList<MovieEntity>>()
        favoriteMovie.value = dummyFavoriteMovie
        `when`(movieRepository.getFavoriteMovie()).thenReturn(favoriteMovie)
        val movieEntities = viewModel.getFavoriteMovie().value
        verify(movieRepository).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getFavoriteMovie().observeForever(observer)
        verify(observer).onChanged(dummyFavoriteMovie)
    }
}