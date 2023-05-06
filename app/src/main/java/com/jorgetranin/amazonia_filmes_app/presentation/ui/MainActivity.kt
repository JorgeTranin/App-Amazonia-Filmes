package com.jorgetranin.amazonia_filmes_app.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.jorgetranin.amazonia_filmes_app.data.Movie
import com.jorgetranin.amazonia_filmes_app.databinding.ActivityMainBinding
import com.jorgetranin.amazonia_filmes_app.presentation.ui.adapter.MovieAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val list = arrayListOf(
            Movie(
                id = 1,
                titulo = "jorge",
                descricao = null,
                imagem = null,
                dataDeLancamento = "oooi"
            ), Movie(
                id = 1,
                titulo = "Pedro",
                descricao = null,
                imagem = null,
                dataDeLancamento = "oooi"
            )

        )
        adapter = MovieAdapter(list)

        //Aplica e inicia o adapter
        binding.rvMovies.setHasFixedSize(true)
        binding.rvMovies.setLayoutManager(LinearLayoutManager(this@MainActivity))
        binding.rvMovies.adapter = adapter




    }
}