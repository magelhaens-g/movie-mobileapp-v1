package com.dvlpr.submission1_maghelheansgultom.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "rating")
    var rating: String,

    @ColumnInfo(name = "director")
    var director: String,

    @ColumnInfo(name = "desc")
    var desc: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false,

    @ColumnInfo(name = "imagePath")
    var imagePath: String
)
