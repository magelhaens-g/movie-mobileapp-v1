package com.dvlpr.submission1_maghelheansgultom.ui.tvShow

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
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import com.dvlpr.submission1_maghelheansgultom.databinding.FragmentTvShowBinding
import com.dvlpr.submission1_maghelheansgultom.ui.detail.DetailTVShowActivity
import com.dvlpr.submission1_maghelheansgultom.viewmodel.ViewModelFactory
import com.dvlpr.submission1_maghelheansgultom.vo.Status

class TVShowFragment : Fragment(), TvShowCallback {
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter(this)
            viewModel.getTvShows().observe(viewLifecycleOwner, { tvShows ->
                if (tvShows != null) {
                    when (tvShows.status) {
                        Status.LOADING -> fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentTvShowBinding.progressBar.visibility = View.GONE
                            tvShowAdapter.submitList(tvShows.data)
                        }
                        Status.ERROR -> {
                            fragmentTvShowBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, resources.getString(R.string.terjadi_kesalahan), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentTvShowBinding.rvTvShow) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = tvShowAdapter
            }
        }
    }

    override fun onItemClicked(item: TVShowsEntity) {
        startActivity(Intent(context, DetailTVShowActivity::class.java)
            .putExtra(DetailTVShowActivity.EXTRA_TV_SHOW, item.tvShowsId))
    }

    override fun onItemShared(item: TVShowsEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Share this TV Show")
                .setText("More details about \"${item.title}\" in themoviedb.org")
                .startChooser()
        }
    }
}