package com.dvlpr.submission1_maghelheansgultom.ui.tvShow

import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.TVShowsEntity

interface TvShowCallback {
    fun onItemClicked(item: TVShowsEntity)
    fun onItemShared(item: TVShowsEntity)
}