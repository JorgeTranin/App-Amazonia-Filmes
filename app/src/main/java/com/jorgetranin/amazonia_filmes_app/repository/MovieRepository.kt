package com.jorgetranin.amazonia_filmes_app.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.jorgetranin.amazonia_filmes_app.data.Movie
import com.jorgetranin.amazonia_filmes_app.data.api.MovieRestApiTesk

class MovieRepository(private val movieRestApiTesk: MovieRestApiTesk) {

    private val movieList = arrayListOf<Movie>()

    fun getAllMovies(): List<Movie> {

        val request = movieRestApiTesk.service.getAllMovie().execute()

        if (request.isSuccessful) {
            request.body()?.let { movieBodyResponse ->
                movieList.addAll(movieBodyResponse)
            }
        } else {
            request.errorBody()?.let {

                Log.e(TAG, it.string())
            }
        }

        return movieList
    }
}