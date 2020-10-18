package com.kharismarizqii.movieapp.ui.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kharismarizqii.movieapp.data.local.FavoriteMovie
import com.kharismarizqii.movieapp.data.local.FavoriteMovieRepository

class FavoriteViewModel @ViewModelInject constructor(
    private val repository: FavoriteMovieRepository
) : ViewModel(){
    val movies = repository.getFavoriteMovies()
}