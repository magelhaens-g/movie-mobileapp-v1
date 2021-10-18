package com.dvlpr.submission1_maghelheansgultom.ui.favorite.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import com.dvlpr.submission1_maghelheansgultom.databinding.FragmentTvShowBinding
import com.dvlpr.submission1_maghelheansgultom.ui.detail.DetailTVShowActivity
import com.dvlpr.submission1_maghelheansgultom.ui.tvShow.TvShowAdapter
import com.dvlpr.submission1_maghelheansgultom.ui.tvShow.TvShowCallback
import com.dvlpr.submission1_maghelheansgultom.viewmodel.ViewModelFactory

class FavTvShowFragment : Fragment(), TvShowCallback {
    private var _favoriteTvShowBinding: FragmentTvShowBinding? = null
    private val binding get() = _favoriteTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _favoriteTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavTvShowViewModel::class.java]
            val adapter = TvShowAdapter(this)

            binding?.apply {
                progressBar.visibility = View.VISIBLE
                viewModel.getFavoriteTvShow().observe(viewLifecycleOwner, { tvShow ->
                    progressBar.visibility = View.GONE
                    adapter.submitList(tvShow)
                    isEmpty(tvShow.isNullOrEmpty())
                })

                rvTvShow.layoutManager = LinearLayoutManager(context)
                rvTvShow.setHasFixedSize(true)
                rvTvShow.adapter = adapter
            }
        }
    }

    private fun isEmpty(nullOrEmpty: Boolean) {
        binding?.apply {
            if (nullOrEmpty) {
                ivNotFoundTvShow.visibility = View.VISIBLE
                tvNotFoundTvShow.visibility = View.VISIBLE
            } else {
                ivNotFoundTvShow.visibility = View.GONE
                tvNotFoundTvShow.visibility = View.GONE
            }
        }
    }

    override fun onItemClicked(item: TVShowsEntity) {
        startActivity(
            Intent(context, DetailTVShowActivity::class.java)
            .putExtra(DetailTVShowActivity.EXTRA_TV_SHOW, item.tvShowsId))
    }

    override fun onItemShared(item: TVShowsEntity) {
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