package com.jorgetranin.amazonia_filmes_app.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val titulo: String,
    val descricao: String?,
    val imagem: String?,
    val dataDeLancamento: String?
) : Parcelable
