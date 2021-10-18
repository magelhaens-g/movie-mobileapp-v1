package com.dvlpr.submission1_maghelheansgultom.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    var movieId: String,
    var title: String,
    var genre: String,
    var rating: String,
    var director: String,
    var desc: String,
    var releaseDate: String,
    var favorite: Boolean = false,
    var imagePath: String
):Parcelable
