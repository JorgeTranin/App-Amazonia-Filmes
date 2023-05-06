package com.jorgetranin.amazonia_filmes_app.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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

        fun bind(item: Movie) {
            binding.tvNome.text = item.titulo
            // Bind other views as necessary
        }
    }

}
