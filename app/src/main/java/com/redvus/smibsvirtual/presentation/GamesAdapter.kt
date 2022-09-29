package com.redvus.smibsvirtual.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.redvus.smibsvirtual.R
import com.redvus.smibsvirtual.data.Game

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
        holder.bindGames(games[position])
    }

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val appImage: ImageView = itemView.findViewById(R.id.image_view_game_icon)
        private val appTitle: TextView = itemView.findViewById(R.id.game_button_download)
        private val appDescription: TextView = itemView.findViewById(R.id.text_view_game_description)

        fun bindGames(game: Game) {
            appImage.setImageResource(game.image)
            appTitle.text = game.name
            appDescription.text = game.description
        }
    }
}