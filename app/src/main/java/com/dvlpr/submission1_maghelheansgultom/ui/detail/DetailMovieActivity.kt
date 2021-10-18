package com.dvlpr.submission1_maghelheansgultom.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dvlpr.submission1_maghelheansgultom.R
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.dvlpr.submission1_maghelheansgultom.databinding.ActivityDetailMovieBinding
import com.dvlpr.submission1_maghelheansgultom.databinding.ContentDetailMovieBinding
import com.dvlpr.submission1_maghelheansgultom.viewmodel.ViewModelFactory
import com.dvlpr.submission1_maghelheansgultom.vo.Status

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var detailContentBinding: ContentDetailMovieBinding
    private lateinit var viewModel: DetailViewModel

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent
        setContentView(activityDetailMovieBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
                activityDetailMovieBinding.content.visibility = View.INVISIBLE
                viewModel.setSelectedMovie(movieId)
                viewModel.movieDetail.observe(this, { movieResource ->
                    if (movieResource != null) {
                        when (movieResource.status) {
                            Status.LOADING -> activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> if (movieResource.data != null) {
                                activityDetailMovieBinding.progressBar.visibility = View.GONE
                                activityDetailMovieBinding.content.visibility = View.VISIBLE
                                movieResource.data.let { movie ->
                                    populateMovie(movie)
                                    val state = movie.favorite
                                    setFavoriteButtonState(state)
                                    detailContentBinding.btnFavorite.setOnClickListener { setFavorite(state) }
                                }
                            }
                            Status.ERROR -> {
                                activityDetailMovieBinding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, resources.getString(R.string.terjadi_kesalahan), Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }

        detailContentBinding.btnBack.setOnClickListener {
            this@DetailMovieActivity.finish()
        }
    }

    private fun setFavorite(state: Boolean) {
        viewModel.setMovieFavorite()
        if (state) {
            Toast.makeText(this, resources.getString(R.string.remove), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, resources.getString(R.string.added), Toast.LENGTH_SHORT).show()
        }
    }

    private fun setFavoriteButtonState(state: Boolean) {
        detailContentBinding.apply {
            if (state) {
                btnFavorite.setImageResource(R.drawable.ic_favorite_white)
            } else {
                btnFavorite.setImageResource(R.drawable.ic_favorite_black)
            }
        }
    }

    private fun populateMovie(movie: MovieEntity) {
        detailContentBinding.apply {
            tvTitle.text = movie.title
            tvDate.text = movie.releaseDate
            tvGenre.text = movie.genre
            tvDirectorValue.text = movie.director
            tvRatingValue.text = movie.rating
            tvDescValue.text = movie.desc

            Glide.with(this@DetailMovieActivity)
                .load(movie.imagePath)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(imageView2)
        }
    }
}