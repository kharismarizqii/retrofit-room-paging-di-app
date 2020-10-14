package com.kharismarizqii.movieapp.data

import com.kharismarizqii.movieapp.api.MovieApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieApi: MovieApi){

}