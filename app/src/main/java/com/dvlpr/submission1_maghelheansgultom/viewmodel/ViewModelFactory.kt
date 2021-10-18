package com.dvlpr.submission1_maghelheansgultom.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dvlpr.submission1_maghelheansgultom.data.source.MovieRepository
import com.dvlpr.submission1_maghelheansgultom.ui.detail.DetailViewModel
import com.dvlpr.submission1_maghelheansgultom.di.Injection
import com.dvlpr.submission1_maghelheansgultom.ui.favorite.movie.FavMovieViewModel
import com.dvlpr.submission1_maghelheansgultom.ui.favorite.tvshow.FavTvShowViewModel
import com.dvlpr.submission1_maghelheansgultom.ui.movie.MovieViewModel
import com.dvlpr.submission1_maghelheansgultom.ui.tvShow.TvShowViewModel

class ViewModelFactory private constructor(private val mMovieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(FavMovieViewModel::class.java) -> {
                FavMovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(FavTvShowViewModel::class.java) -> {
                FavTvShowViewModel(mMovieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}