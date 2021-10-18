package com.dvlpr.submission1_maghelheansgultom.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dvlpr.submission1_maghelheansgultom.data.source.MovieDataSource
import com.dvlpr.submission1_maghelheansgultom.data.source.NetworkBoundResource
import com.dvlpr.submission1_maghelheansgultom.data.source.local.LocalDataSource
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import com.dvlpr.submission1_maghelheansgultom.data.source.remote.ApiResponse
import com.dvlpr.submission1_maghelheansgultom.data.source.remote.RemoteDataSource
import com.dvlpr.submission1_maghelheansgultom.data.source.remote.response.MovieResponse
import com.dvlpr.submission1_maghelheansgultom.data.source.remote.response.TVShowResponse
import com.dvlpr.submission1_maghelheansgultom.utils.AppExecutors
import com.dvlpr.submission1_maghelheansgultom.vo.Resource

class FakeMovieRepository (private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource, private val appExecutors: AppExecutors) :
    MovieDataSource {
    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponse) {
                    val movie = MovieEntity(response.movieId,
                        response.title,
                        response.genre,
                        response.rating,
                        response.director,
                        response.desc,
                        response.releaseDate,
                        false,
                        response.imagePath)
                    movieList.add(movie)
                }
                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvShows(): LiveData<Resource<PagedList<TVShowsEntity>>> {
        return object : NetworkBoundResource<PagedList<TVShowsEntity>, List<TVShowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TVShowsEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TVShowsEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TVShowResponse>>> =
                remoteDataSource.getAllTvShows()

            override fun saveCallResult(tvShowResponse: List<TVShowResponse>) {
                val tvShowList = ArrayList<TVShowsEntity>()
                for (response in tvShowResponse) {
                    val tvShow = TVShowsEntity(response.tvShowsId,
                        response.title,
                        response.genre,
                        response.rating,
                        response.creator,
                        response.desc,
                        response.status,
                        false,
                        response.imagePath)
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShow(tvShowList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movieId: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieResponse>(appExecutors) {
            public override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getMovieDetail(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            public override fun createCall(): LiveData<ApiResponse<MovieResponse>> =
                remoteDataSource.getMovieDetail(movieId)

            public override fun saveCallResult(movieResponse: MovieResponse) {
                with(movieResponse) {
                    val movie = MovieEntity(
                        movieId,
                        title,
                        genre,
                        rating,
                        director,
                        desc,
                        releaseDate,
                        favorite,
                        imagePath
                    )
                    localDataSource.getMovieDetail(movie.movieId)
                }
            }
        }.asLiveData()
    }

    override fun getDetailTvShow(tvShowId: String): LiveData<Resource<TVShowsEntity>> {
        return object : NetworkBoundResource<TVShowsEntity, TVShowResponse>(appExecutors) {
            public override fun loadFromDB(): LiveData<TVShowsEntity> =
                localDataSource.getTvShowDetail(tvShowId)

            override fun shouldFetch(data: TVShowsEntity?): Boolean =
                data == null

            public override fun createCall(): LiveData<ApiResponse<TVShowResponse>> =
                remoteDataSource.getTvShowDetail(tvShowId)

            public override fun saveCallResult(tvShowResponse: TVShowResponse) {
                with(tvShowResponse) {
                    val tvShow = TVShowsEntity(
                        tvShowId,
                        title,
                        genre,
                        rating,
                        creator,
                        desc,
                        status,
                        favorite,
                        imagePath
                    )
                    localDataSource.getTvShowDetail(tvShow.tvShowsId)
                }
            }
        }.asLiveData()
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }


    override fun getFavoriteTvShow(): LiveData<PagedList<TVShowsEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShow(), config).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute{ localDataSource.setMovieFavorite(movie, state) }

    override fun setFavoriteTvShow(tvShow: TVShowsEntity, state: Boolean) =
        appExecutors.diskIO().execute{ localDataSource.setTvShowFavorite(tvShow, state)}
}