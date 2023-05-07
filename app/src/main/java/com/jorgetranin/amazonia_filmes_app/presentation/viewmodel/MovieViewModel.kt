package com.jorgetranin.amazonia_filmes_app.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jorgetranin.amazonia_filmes_app.data.api.MovieRestApiTesk
import com.jorgetranin.amazonia_filmes_app.data.domain.Movie
import com.jorgetranin.amazonia_filmes_app.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MovieViewModel : ViewModel() {

    private val movieRestApiTesk = MovieRestApiTesk
    private val movieRepository = MovieRepository(movieRestApiTesk)

    private var _listMovies = MutableLiveData<List<Movie>>()
    val listMovies: MutableLiveData<List<Movie>>
        get() = _listMovies

    fun init() {
        CoroutineScope(Dispatchers.IO).launch {

            val result = getAllMovies()

            withContext(Dispatchers.Main) {
                return@withContext result
            }
        }

    }


    suspend fun getAllMovies() {
        CoroutineScope(Dispatchers.IO).launch {

            val result = movieRepository.getAllMovies()

            withContext(Dispatchers.Main) {

                _listMovies.postValue(result)
            }
        }

    }


}