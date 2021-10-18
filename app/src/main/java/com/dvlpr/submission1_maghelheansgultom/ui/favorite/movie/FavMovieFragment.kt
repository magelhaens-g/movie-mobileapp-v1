package com.dvlpr.submission1_maghelheansgultom.ui.favorite.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.dvlpr.submission1_maghelheansgultom.databinding.FragmentMovieBinding
import com.dvlpr.submission1_maghelheansgultom.ui.detail.DetailMovieActivity
import com.dvlpr.submission1_maghelheansgultom.ui.movie.MovieAdapter
import com.dvlpr.submission1_maghelheansgultom.ui.movie.MovieCallback
import com.dvlpr.submission1_maghelheansgultom.viewmodel.ViewModelFactory

class FavMovieFragment : Fragment(), MovieCallback {
    private var _favoriteMoveBinding: FragmentMovieBinding? = null
    private val binding get() = _favoriteMoveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _favoriteMoveBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavMovieViewModel::class.java]
            val  adapter = MovieAdapter(this)

            binding?.apply {
                progressBar.visibility = View.VISIBLE
                viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { movies ->
                    progressBar.visibility = View.GONE
                    adapter.submitList(movies)
                    isEmpty(movies.isNullOrEmpty())
                })

                rvMovie.layoutManager = LinearLayoutManager(context)
                rvMovie.setHasFixedSize(true)
                rvMovie.adapter = adapter
            }
        }
    }

    private fun isEmpty(nullOrEmpty: Boolean) {
        binding?.apply {
            if (nullOrEmpty) {
                ivNotFoundMovie.visibility = View.VISIBLE
                tvNotFoundMovie.visibility = View.VISIBLE
            } else {
                ivNotFoundMovie.visibility = View.GONE
                tvNotFoundMovie.visibility = View.GONE
            }
        }
    }

    override fun onItemClicked(item: MovieEntity) {
        startActivity(Intent(context, DetailMovieActivity::class.java)
            .putExtra(DetailMovieActivity.EXTRA_MOVIE, item.movieId))
    }

    override fun onItemShared(item: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Share this Movie")
                .setText("More details about \"${item.title}\" in themoviedb.org")
                .startChooser()
        }
    }
}