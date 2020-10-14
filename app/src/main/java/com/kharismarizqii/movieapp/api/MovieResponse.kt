package com.kharismarizqii.movieapp.api

import com.kharismarizqii.movieapp.data.model.Movie

data class MovieResponse(
    val results: List<Movie>
)