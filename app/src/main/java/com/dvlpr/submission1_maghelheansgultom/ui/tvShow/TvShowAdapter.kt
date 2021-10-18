package com.dvlpr.submission1_maghelheansgultom.ui.tvShow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dvlpr.submission1_maghelheansgultom.R
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity
import com.dvlpr.submission1_maghelheansgultom.databinding.ItemsRvBinding

class TvShowAdapter(private val callback: TvShowCallback) : PagedListAdapter<TVShowsEntity, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TVShowsEntity>() {
            override fun areItemsTheSame(oldItem: TVShowsEntity, newItem: TVShowsEntity): Boolean {
                return oldItem.tvShowsId == newItem.tvShowsId
            }
            override fun areContentsTheSame(oldItem: TVShowsEntity, newItem: TVShowsEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class TvShowViewHolder(private val binding: ItemsRvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvshow: TVShowsEntity) {
            with(binding) {
                tvItemTitle.text = tvshow.title
                tvItemGenre.text = tvshow.genre
                tvItemDesc.text = tvshow.desc
                itemView.setOnClickListener { callback.onItemClicked(tvshow) }
                btnShare.setOnClickListener { callback.onItemShared(tvshow) }
                Glide.with(itemView.context)
                    .load(tvshow.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsRvBinding = ItemsRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsRvBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvshow = getItem(position)
        if (tvshow != null) {
            holder.bind(tvshow)
        }
    }
}
