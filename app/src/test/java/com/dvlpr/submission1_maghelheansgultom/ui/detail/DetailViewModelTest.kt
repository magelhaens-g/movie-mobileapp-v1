package com.dvlpr.submission1_maghelheansgultom.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.MovieRepository
import com.dvlpr.submission1_maghelheansgultom.utils.DataDummy
import com.dvlpr.submission1_maghelheansgultom.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import com.nhaarman.mockitokotlin2.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTVShows()[0]
    private val movieId = dummyMovie.movieId
    private val tvShowId = dummyTvShow.tvShowsId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TVShowsEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieRepository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getMovie() {
        val dummyMovies = Resource.success(DataDummy.generateDummyMovies()[0])
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovies
        `when`(movieRepository.getDetailMovie(movieId)).thenReturn(movie)
        viewModel.movieDetail = movieRepository.getDetailMovie(movieId)
        val movieEntity = viewModel.movieDetail.value?.data as MovieEntity
        verify(movieRepository).getDetailMovie(movieId)
        assertNotNull(movie)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.director, movieEntity.director)
        assertEquals(dummyMovie.rating, movieEntity.rating)
        assertEquals(dummyMovie.desc, movieEntity.desc)
        assertEquals(dummyMovie.favorite, movieEntity.favorite)
        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)

        viewModel.movieDetail.observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies)
    }

    @Test
    fun getTvShow() {
        val dummyTvShows = Resource.success(DataDummy.generateDummyTVShows()[0])
        val tvShow = MutableLiveData<Resource<TVShowsEntity>>()
        tvShow.value = dummyTvShows
        `when`(movieRepository.getDetailTvShow(tvShowId)).thenReturn(tvShow)
        viewModel.tvShowDetail = movieRepository.getDetailTvShow(tvShowId)
        val tvShowEntity = viewModel.tvShowDetail.value?.data as TVShowsEntity
        verify(movieRepository).getDetailTvShow(tvShowId)
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.tvShowsId, tvShowEntity.tvShowsId)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.status, tvShowEntity.status)
        assertEquals(dummyTvShow.genre, tvShowEntity.genre)
        assertEquals(dummyTvShow.creator, tvShowEntity.creator)
        assertEquals(dummyTvShow.rating, tvShowEntity.rating)
        assertEquals(dummyTvShow.desc, tvShowEntity.desc)
        assertEquals(dummyTvShow.favorite, tvShowEntity.favorite)
        assertEquals(dummyTvShow.imagePath, tvShowEntity.imagePath)

        viewModel.tvShowDetail.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShows)
    }

    @Test
    fun setFavoriteMovie() {
        val dummyMovie = Resource.success(DataDummy.generateDummyMovies()[0])
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie

        `when`(movieRepository.getDetailMovie(movieId)).thenReturn(movie)
        viewModel.movieDetail = movieRepository.getDetailMovie(movieId)
        viewModel.setMovieFavorite()
        verify(movieRepository).setFavoriteMovie(movie.value?.data as MovieEntity, true)
    }

    @Test
    fun setFavoriteTvShow() {
        val dummyTvShow = Resource.success(DataDummy.generateDummyTVShows()[0])
        val tvShow = MutableLiveData<Resource<TVShowsEntity>>()
        tvShow.value = dummyTvShow

        `when`(movieRepository.getDetailTvShow(movieId)).thenReturn(tvShow)
        viewModel.tvShowDetail = movieRepository.getDetailTvShow(movieId)
        viewModel.setTvShowFavorite()
        verify(movieRepository).setFavoriteTvShow(tvShow.value?.data as TVShowsEntity, true)
    }
}