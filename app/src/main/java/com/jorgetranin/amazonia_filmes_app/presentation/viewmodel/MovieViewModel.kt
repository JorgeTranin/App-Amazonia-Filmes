package com.jorgetranin.amazonia_filmes_app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.jorgetranin.amazonia_filmes_app.data.Movie

class MovieViewModel: ViewModel() {
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

    fun insert(movie: Movie){
        val listMovie: Movie = movie
    }

}