package com.dvlpr.submission1_maghelheansgultom.ui.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dvlpr.submission1_maghelheansgultom.R
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.dvlpr.submission1_maghelheansgultom.databinding.FragmentMovieBinding
import com.dvlpr.submission1_maghelheansgultom.ui.detail.DetailMovieActivity
import com.dvlpr.submission1_maghelheansgultom.viewmodel.ViewModelFactory
import com.dvlpr.submission1_maghelheansgultom.vo.Status

class MovieFragment : Fragment(), MovieCallback {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter(this)
            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> fragmentMovieBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentMovieBinding.progressBar.visibility = View.GONE
                            movieAdapter.submitList(movies.data)
                        }
                        Status.ERROR -> {
                            fragmentMovieBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, resources.getString(R.string.terjadi_kesalahan), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
//            viewModel.getMovies().observe(viewLifecycleOwner, observer)


            with(fragmentMovieBinding.rvMovie) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }
    }

    /*private val observer: Observer<Resource<PagedList<MovieEntity>>> =
        Observer { movies ->
            if (movies != null) {
                when (movies.status) {
                    Status.LOADING -> fragmentMovieBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        fragmentMovieBinding.progressBar.visibility = View.GONE
                        movieAdapter.submitList(movies.data)
                    }
                    Status.ERROR -> {
                        fragmentMovieBinding.progressBar.visibility = View.GONE
                        Toast.makeText(context, resources.getString(R.string.terjadi_kesalahan), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }*/

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