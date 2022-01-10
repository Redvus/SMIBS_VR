package com.redvus.smibsvirtual.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.redvus.smibsvirtual.Game
import com.redvus.smibsvirtual.R

class GamesAdapter(games: Array<Game>) : RecyclerView.Adapter<GamesAdapter.GameViewHolder>() {

    private var games: Array<Game> = games

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(games[position])
    }

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val appImage: ImageView = itemView.findViewById(R.id.image_view_game_icon)
//        private val appTitle: TextView = itemView.findViewById(R.id.text_view_game_title)
//        private val appDescription: TextView = itemView.findViewById(R.id.text_view_game_description)

        fun bind(game: Game) {
//            appTitle.text = game.name
//            appDescription.text = game.description
            appImage.setImageResource(game.image)
        }
    }
}