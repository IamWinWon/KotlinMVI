package ru.mrwinwon.kotlinmvi.features.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import kotlinx.android.synthetic.main.item_movie.view.*
import ru.mrwinwon.domain.entities.MovieLocal
import ru.mrwinwon.kotlinmvi.R

/**
 * Created by Artem Winokurov on 14.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var moviesList: MutableList<MovieLocal> = ArrayList()

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageViewCharacterImage: ImageView = itemView.item_character_image
        private val textViewCharacterName: TextView = itemView.item_character_name

        fun bindMovies(movie: MovieLocal) {
            with(movie) {
                textViewCharacterName.text = title
                imageViewCharacterImage.load("https://$poster")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovies(moviesList[position])
    }

    fun updateList(characterList: MutableList<MovieLocal>) {
        moviesList = characterList
        notifyDataSetChanged()
    }

    fun addToList(movieList: List<MovieLocal>) {
        this.moviesList.addAll(movieList)
        notifyDataSetChanged()
    }
}