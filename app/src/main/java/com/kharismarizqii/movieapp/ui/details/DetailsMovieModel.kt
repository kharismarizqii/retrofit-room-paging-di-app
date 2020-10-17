package com.kharismarizqii.movieapp.ui.details

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.kharismarizqii.movieapp.data.local.FavoriteMovie
import com.kharismarizqii.movieapp.data.local.FavoriteMovieRepository
import com.kharismarizqii.movieapp.data.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsMovieModel @ViewModelInject constructor(
    private val repository : FavoriteMovieRepository
) : ViewModel(){
    fun addToFavorite(movie: Movie){
        CoroutineScope(Dispatchers.IO).launch {
            repository.addToFavorite(
                FavoriteMovie(
                    movie.id,
                    movie.original_title,
                    movie.overview,
                    movie.poster_path
                )
            )
        }
    }

    suspend fun checkMovie(id: String) = repository.checkMovie(id)

    fun removeFromFavorite(id: String){
        CoroutineScope(Dispatchers.IO).launch {
            repository.removeFromFavorite(id)
        }
    }

}