package com.jorgetranin.amazonia_filmes_app.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jorgetranin.amazonia_filmes_app.data.domain.Movie
import com.jorgetranin.amazonia_filmes_app.databinding.ActivityMainBinding
import com.jorgetranin.amazonia_filmes_app.presentation.ui.adapter.MovieAdapter
import com.jorgetranin.amazonia_filmes_app.presentation.viewmodel.MovieViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MovieViewModel

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        viewModel = ViewModelProvider.NewInstanceFactory().create(MovieViewModel::class.java)


        initiObserver()


    }

    override fun onStart() {
        super.onStart()
        viewModel.init()
        loadVisibility(true)

    }

    private fun initiObserver() {
        viewModel.listMovies.observe(this) { listMovie ->
            if (listMovie.isNotEmpty()) {
                loadVisibility(false)
                loadMovies(listMovie)

            }


        }
    }

    private fun loadMovies(listMovie: List<Movie>) {
        //set de um layout para minha recycler view

        binding.rvMovies.setHasFixedSize(true)
        binding.rvMovies.layoutManager = LinearLayoutManager(this@MainActivity)

        //passa para meu adapter a lista a ser consumida
        adapter = MovieAdapter(listMovie)
        binding.rvMovies.adapter = adapter

    }

    private fun loadVisibility(isLoading: Boolean) {

        binding.pbLoadMovies.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}