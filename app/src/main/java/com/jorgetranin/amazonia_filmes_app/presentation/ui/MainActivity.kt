package com.jorgetranin.amazonia_filmes_app.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jorgetranin.amazonia_filmes_app.databinding.ActivityMainBinding
import com.jorgetranin.amazonia_filmes_app.presentation.ui.adapter.MovieAdapter
import com.jorgetranin.amazonia_filmes_app.presentation.viewmodel.MovieViewModel


class MainActivity : AppCompatActivity() {
    private val viewModel: MovieViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        loadMovies()

        //Aplica e inicia o adapter






    }
    private fun loadMovies() {
        //set de um layout para minha recycler view

        viewModel.init().observe(this) { movies ->
            //passa para meu adapter a lista a ser consumida
            binding.rvMovies.setHasFixedSize(true)
            binding.rvMovies.setLayoutManager(LinearLayoutManager(this@MainActivity))
            binding.rvMovies.adapter = adapter
        }
    }
}