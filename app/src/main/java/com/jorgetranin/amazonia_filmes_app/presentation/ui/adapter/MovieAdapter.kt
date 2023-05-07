package com.jorgetranin.amazonia_filmes_app.presentation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jorgetranin.amazonia_filmes_app.R
import com.jorgetranin.amazonia_filmes_app.data.Movie
import com.jorgetranin.amazonia_filmes_app.databinding.ItemMovieBinding


class MovieAdapter(private val moviesList:List<Movie>) : RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(moviesList[position])


    }

    inner class MoviesViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var context: Context = itemView.context
        fun bind(item: Movie) {
            val url = "https://cdn.pixabay.com/photo/2017/07/25/22/54/lego-2539844_1280.jpg"
            binding.tvTitleFilme.text = item.titulo
            binding.tvDescripitionFilme.text = item.descricao
            binding.tvDataLancamento.text = item.dataDeLancamento

            Glide.with(context).load(url).centerCrop().placeholder(R.drawable.insert_photo).into(binding.ivMovie)


            // Bind other views as necessary
        }
    }

}
