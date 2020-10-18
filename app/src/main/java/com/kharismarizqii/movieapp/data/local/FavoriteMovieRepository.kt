package com.kharismarizqii.movieapp.data.local

import androidx.lifecycle.LiveData
import javax.inject.Inject

class FavoriteMovieRepository @Inject constructor(
    private val favoriteMovieDao: FavoriteMovieDao
){
    suspend fun addToFavorite(favoriteMovie: FavoriteMovie) = favoriteMovieDao.addToFavorite(favoriteMovie)
    fun getFavoriteMovies() = favoriteMovieDao.getFavoriteMovie()
    suspend fun checkMovie(id: String) = favoriteMovieDao.checkMovie(id)
    suspend fun removeFromFavorite(id: String) {
        favoriteMovieDao.removeFromFavorite(id)
    }
}