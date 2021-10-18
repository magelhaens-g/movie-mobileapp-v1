package com.dvlpr.submission1_maghelheansgultom.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dvlpr.submission1_maghelheansgultom.R
import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity
import com.dvlpr.submission1_maghelheansgultom.databinding.ItemsRvBinding

class MovieAdapter(private val callback: MovieCallback) : PagedListAdapter<MovieEntity, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class MovieViewHolder(private val binding: ItemsRvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemGenre.text = movie.genre
                tvItemDesc.text = movie.desc
                itemView.setOnClickListener { callback.onItemClicked(movie) }
                btnShare.setOnClickListener { callback.onItemShared(movie) }
                Glide.with(itemView.context)
                    .load(movie.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsRvBinding = ItemsRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsRvBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }
}