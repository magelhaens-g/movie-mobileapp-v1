package com.dvlpr.submission1_maghelheansgultom.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowentities")
data class TVShowsEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowsId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "rating")
    var rating: String,

    @ColumnInfo(name = "creator")
    var creator: String,

    @ColumnInfo(name = "desc")
    var desc: String,

    @ColumnInfo(name = "status")
    var status: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false,

    @ColumnInfo(name = "imagePath")
    var imagePath: String
)
