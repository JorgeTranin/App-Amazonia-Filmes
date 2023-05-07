package com.jorgetranin.amazonia_filmes_app.data.api

import com.jorgetranin.amazonia_filmes_app.data.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {
    @GET(value = "filmes.json")
    fun getAllMovie(): Call<List<Movie>>

}