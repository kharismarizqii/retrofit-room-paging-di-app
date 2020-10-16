package com.kharismarizqii.movieapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.kharismarizqii.movieapp.api.MovieApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieApi: MovieApi){

    fun getNowPlayingMovies() =
        Pager(
            config = PagingConfig(
                pageSize = 18,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {MoviePagingSource(movieApi)}
        ).liveData

}