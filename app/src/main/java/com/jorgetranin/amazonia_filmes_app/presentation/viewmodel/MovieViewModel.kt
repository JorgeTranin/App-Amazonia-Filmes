package com.jorgetranin.amazonia_filmes_app.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jorgetranin.amazonia_filmes_app.data.Movie
import com.jorgetranin.amazonia_filmes_app.data.api.MovieRestApiTesk
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private var _listMovies = MutableLiveData<List<Movie>>()
    val listMovies: MutableLiveData<List<Movie>>
        get() = _listMovies

    fun init() {
        this.getAllMovies()
    }


    fun getAllMovies() {

        MovieRestApiTesk.service.getAllMovie().enqueue(object : Callback<List<Movie>> {
            override fun onResponse(
                call: Call<List<Movie>>,
                response: Response<List<Movie>>
            ) {
                if (response.isSuccessful) {
                    val movies: MutableList<Movie> = mutableListOf()
                    response.body()?.let { movieBodyResponse ->
                        _listMovies.value = movieBodyResponse

                        for (result in movieBodyResponse) {
                            val movie = Movie(
                                id = result.id,
                                titulo = result.titulo,
                                descricao = result.descricao,
                                imagem = result.imagem,
                                dataDeLancamento = result.dataDeLancamento,


                                )
                            movies.add(movie)
                        }


                    }
                    // mesma coisa de passar os dados fakes, porem desta forma é adicionado os resultados vindos da api
                    _listMovies.value = movies
                }
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })


    }
}