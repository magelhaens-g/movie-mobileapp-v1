package com.dvlpr.submission1_maghelheansgultom.data.source.remote

import android.os.Looper
import com.dvlpr.submission1_maghelheansgultom.data.source.remote.response.MovieResponse
import com.dvlpr.submission1_maghelheansgultom.data.source.remote.response.TVShowResponse
import com.dvlpr.submission1_maghelheansgultom.utils.JsonHelper
import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dvlpr.submission1_maghelheansgultom.utils.EspressoIdlingResource

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
            }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<TVShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TVShowResponse>>>()
        handler.postDelayed({
            resultTvShow.value = ApiResponse.success(jsonHelper.loadTvShows())
            EspressoIdlingResource.decrement()
            }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShow
    }

    fun getMovieDetail(movieId: String): LiveData<ApiResponse<MovieResponse>> {
        EspressoIdlingResource.increment()
        val movie = MutableLiveData<ApiResponse<MovieResponse>>()
        handler.postDelayed({
            movie.value = ApiResponse.success(jsonHelper.getMovieDetail(movieId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return movie
    }

    fun getTvShowDetail(tvShowId: String): LiveData<ApiResponse<TVShowResponse>> {
        EspressoIdlingResource.increment()
        val tvShow = MutableLiveData<ApiResponse<TVShowResponse>>()
        handler.postDelayed({
            tvShow.value = ApiResponse.success(jsonHelper.getTvShowDetail(tvShowId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return tvShow
    }
}
