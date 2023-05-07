package com.jorgetranin.amazonia_filmes_app.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieRestApiTesk {

    private fun initRtrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jorgetranin.github.io/Amazonia-Filmes-Api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: MovieApi = initRtrofit().create(MovieApi::class.java)


}