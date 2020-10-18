package com.kharismarizqii.movieapp.data.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity(tableName = "favorite_movie")
@Parcelize
data class FavoriteMovie(
    var id_movie: String,
    val original_title: String,
    val overview : String?,
    val poster_path: String
) : Serializable, Parcelable{
    @PrimaryKey (autoGenerate = true)
    var id : Int = 0
    val baseUrl get() = "https://image.tmdb.org/t/p/w500"
}