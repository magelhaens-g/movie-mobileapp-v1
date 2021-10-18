package com.dvlpr.submission1_maghelheansgultom.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TVShowResponse(
    var tvShowsId: String,
    var title: String,
    var genre: String,
    var rating: String,
    var creator: String,
    var desc: String,
    var status: String,
    var favorite: Boolean = false,
    var imagePath: String
):Parcelable
