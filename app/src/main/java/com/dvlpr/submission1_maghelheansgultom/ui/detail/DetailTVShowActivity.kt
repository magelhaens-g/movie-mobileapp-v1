package com.dvlpr.submission1_maghelheansgultom.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dvlpr.submission1_maghelheansgultom.R
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import com.dvlpr.submission1_maghelheansgultom.databinding.ActivityDetailTvShowBinding
import com.dvlpr.submission1_maghelheansgultom.databinding.ContentDetailTvShowBinding
import com.dvlpr.submission1_maghelheansgultom.viewmodel.ViewModelFactory
import com.dvlpr.submission1_maghelheansgultom.vo.Status

class DetailTVShowActivity : AppCompatActivity() {
    private lateinit var detailContentBinding: ContentDetailTvShowBinding
    private lateinit var viewModel: DetailViewModel

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailTVShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailTVShowBinding.detailContent
        setContentView(activityDetailTVShowBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                activityDetailTVShowBinding.progressBar.visibility = View.VISIBLE
                activityDetailTVShowBinding.content.visibility = View.INVISIBLE
                viewModel.setSelectedTvShow(tvShowId)
                viewModel.tvShowDetail.observe(this, { tvShowResource ->
                    if (tvShowResource != null) {
                        when (tvShowResource.status) {
                            Status.LOADING -> activityDetailTVShowBinding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> if (tvShowResource.data != null) {
                                activityDetailTVShowBinding.progressBar.visibility = View.GONE
                                activityDetailTVShowBinding.content.visibility = View.VISIBLE
                                tvShowResource.data.let { tvShow ->
                                    populateTvShow(tvShow)
                                    val state = tvShow.favorite
                                    setFavoriteButtonState(state)
                                    detailContentBinding.btnFavorite.setOnClickListener { setFavorite(state) }
                                }
                            }
                            Status.ERROR -> {
                                activityDetailTVShowBinding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, resources.getString(R.string.terjadi_kesalahan), Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }

        detailContentBinding.btnBack.setOnClickListener {
            this@DetailTVShowActivity.finish()
        }
    }

    private fun setFavorite(state: Boolean) {
        viewModel.setTvShowFavorite()
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

    private fun populateTvShow(tvShow: TVShowsEntity) {
        detailContentBinding.apply {
            tvTitle.text = tvShow.title
            tvStatus.text = tvShow.status
            tvGenre.text = tvShow.genre
            tvCreatorValue.text = tvShow.creator
            tvRatingValue.text = tvShow.rating
            tvDescValue.text = tvShow.desc

            Glide.with(this@DetailTVShowActivity)
                .load(tvShow.imagePath)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(imageView2)
        }
    }
}