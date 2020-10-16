package com.kharismarizqii.movieapp.data

import androidx.paging.PagingSource
import com.kharismarizqii.movieapp.api.MovieApi
import com.kharismarizqii.movieapp.data.model.Movie
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

class MoviePagingSource (
    private val movieApi: MovieApi
): PagingSource<Int, Movie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {


        return try {
            val position = params.key ?: STARTING_PAGE_INDEX
            val response = movieApi.getNowPlayingMovies(position)
            val movies = response.results

            LoadResult.Page(
                data = movies,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position-1,
                nextKey = if (movies.isEmpty()) null else position+1
            )
        } catch (e: IOException){
            LoadResult.Error(e)
        } catch (e: HttpException){
            LoadResult.Error(e)
        }

    }
}