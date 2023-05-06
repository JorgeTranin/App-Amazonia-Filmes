package com.jorgetranin.amazonia_filmes_app.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jorgetranin.amazonia_filmes_app.data.Movie

class MovieViewModel: ViewModel() {
    val list = arrayListOf(
        Movie(
            id = 1,
            titulo = "jorge",
            descricao = "null",
            imagem = "null",
            dataDeLancamento = "21.6.6"
        ), Movie(
            id = 1,
            titulo = "Pedro",
            descricao = "null",
            imagem = "null",
            dataDeLancamento = "21.6.6"
        )

    )
    private var _listMovies = MutableLiveData<List<Movie>>()
    val listMovies: MutableLiveData<List<Movie>>
        get() = _listMovies

    fun init(){
        this.getAllMovies()
    }


    fun getAllMovies() {
        _listMovies.value = list
    }


}