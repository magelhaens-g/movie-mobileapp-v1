package com.dvlpr.submission1_maghelheansgultom.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dvlpr.submission1_maghelheansgultom.data.FakeMovieRepository
import com.dvlpr.submission1_maghelheansgultom.data.source.local.LocalDataSource
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.remote.RemoteDataSource
import com.dvlpr.submission1_maghelheansgultom.utils.AppExecutors
import com.dvlpr.submission1_maghelheansgultom.utils.DataDummy
import com.dvlpr.submission1_maghelheansgultom.utils.LiveDataTestUtil
import com.dvlpr.submission1_maghelheansgultom.utils.PagedListUtil
import com.dvlpr.submission1_maghelheansgultom.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import com.nhaarman.mockitokotlin2.verify
import org.junit.Rule
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val movieRepository = FakeMovieRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieResponse = DataDummy.generateDummyMovies()[0]
    private val movieId = movieResponses[0].movieId
    private val tvShowResponses = DataDummy.generateRemoteDummyTvShows()
    private val tvShowResponse = DataDummy.generateDummyTVShows()[0]
    private val tvShowId = tvShowResponses[0].tvShowsId

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        movieRepository.getAllMovies()
        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowsEntity>
        `when`(local.getAllTvShows()).thenReturn(dataSourceFactory)
        movieRepository.getAllTvShows()
        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTVShows()))
        verify(local).getAllTvShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyEntity = MutableLiveData<MovieEntity>()
        dummyEntity.value = movieResponse
        `when`(local.getMovieDetail(movieId)).thenReturn(dummyEntity)
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getDetailMovie(movieId))
        verify(local).getMovieDetail(movieId)
        assertNotNull(movieEntities.data)
        assertNotNull(movieEntities.data?.title)
        assertEquals(movieResponses[0].title, movieEntities.data?.title)
        assertEquals(movieResponses[0].genre, movieEntities.data?.genre)
        assertEquals(movieResponses[0].rating, movieEntities.data?.rating)
        assertEquals(movieResponses[0].director, movieEntities.data?.director)
        assertEquals(movieResponses[0].desc, movieEntities.data?.desc)
        assertEquals(movieResponses[0].releaseDate, movieEntities.data?.releaseDate)
        assertEquals(movieResponses[0].favorite, movieEntities.data?.favorite)
        assertEquals(movieResponses[0].imagePath, movieEntities.data?.imagePath)
    }

    @Test
    fun getDetailTvShow() {
        val dummyEntity = MutableLiveData<TVShowsEntity>()
        dummyEntity.value = tvShowResponse
        `when`(local.getTvShowDetail(tvShowId)).thenReturn(dummyEntity)
        val tvShowEntities = LiveDataTestUtil.getValue(movieRepository.getDetailTvShow(tvShowId))
        verify(local).getTvShowDetail(tvShowId)
        assertNotNull(tvShowEntities.data)
        assertNotNull(tvShowEntities.data?.title)
        assertEquals(tvShowResponses[0].title, tvShowEntities.data?.title)
        assertEquals(tvShowResponses[0].genre, tvShowEntities.data?.genre)
        assertEquals(tvShowResponses[0].rating, tvShowEntities.data?.rating)
        assertEquals(tvShowResponses[0].creator, tvShowEntities.data?.creator)
        assertEquals(tvShowResponses[0].desc, tvShowEntities.data?.desc)
        assertEquals(tvShowResponses[0].status, tvShowEntities.data?.status)
        assertEquals(tvShowResponses[0].favorite, tvShowEntities.data?.favorite)
        assertEquals(tvShowResponses[0].imagePath, tvShowEntities.data?.imagePath)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteMovie()
        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowsEntity>
        `when`(local.getFavoriteTvShow()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteTvShow()
        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTVShows()))
        verify(local).getFavoriteTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }
}