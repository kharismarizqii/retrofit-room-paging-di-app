package com.kharismarizqii.movieapp.ui.favorite

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kharismarizqii.movieapp.R
import com.kharismarizqii.movieapp.data.local.FavoriteMovie
import com.kharismarizqii.movieapp.data.model.Movie
import com.kharismarizqii.movieapp.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment(R.layout.fragment_favorite){
    private val viewModel by viewModels<FavoriteViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavoriteBinding.bind(view)

        val adapter = FavoriteAdapter()

        viewModel.movies.observe(viewLifecycleOwner){
            adapter.setMovieList(it)
            binding.apply {
                rvMovie.setHasFixedSize(true)
                rvMovie.adapter = adapter
            }
        }


        adapter.setOnItemClickCallback(object : FavoriteAdapter.OnItemClickCallback{
            override fun onItemClick(favoriteMovie: FavoriteMovie) {
                val movie = Movie(
                    favoriteMovie.id_movie,
                    favoriteMovie.overview,
                    favoriteMovie.poster_path,
                    favoriteMovie.original_title
                )
                val action = FavoriteFragmentDirections.actionNavFavoriteToNavDetails(movie)
                findNavController().navigate(action)
            }

        })
    }
}