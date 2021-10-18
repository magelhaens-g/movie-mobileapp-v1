package com.dvlpr.submission1_maghelheansgultom.ui.movie

import com.dvlpr.submission1_maghelheansgultom.data.source.local.entity.MovieEntity

interface MovieCallback {
    fun onItemClicked(item: MovieEntity)
    fun onItemShared(item: MovieEntity)
}