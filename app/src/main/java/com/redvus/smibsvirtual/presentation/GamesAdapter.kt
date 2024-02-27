package com.redvus.smibsvirtual.presentation

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
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
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bindGames(games[position])
    }

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val appImage: ImageView = itemView.findViewById(R.id.image_view_game_icon)
//        private val appButton: TextView = itemView.findViewById(R.id.game_button_download)
//        private val appDescription: TextView =
//            itemView.findViewById(R.id.text_view_game_description)

        fun bindGames(game: Game) {
            appImage.setImageResource(game.image)
//            appButton.text = game.name
//            appDescription.text = game.description
            var appLink = game.packageName

            appImage.setOnClickListener() {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://smibs.ru/${appLink}")
                )
                itemView.context.startActivity(intent)
            }
        }
    }
}

// TODO: Возможные варианты решения 
//val intent = Intent(Intent.ACTION_VIEW).apply {
//    data = Uri.parse(
//        "https://play.google.com/store/apps/details?id=${packageName}")
//    setPackage("com.android.vending")
//}

//    startActivity(intent)

//    try {
//        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
//    } catch (e: ActivityNotFoundException) {
//        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
//    }

// Ссылка на Google Play
// https://stackoverflow.com/questions/11753000/how-to-open-the-google-play-store-directly-from-my-android-application
// https://developer.android.com/distribute/marketing-tools/linking-to-google-play?hl=he#android-app
//    try {
//        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
//    } catch (e: ActivityNotFoundException) {
//        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
//    }

// TODO: Возможное решение клика на кнопке
// https://overcoder.net/q/4157/recyclerview-onclick

// TODO: Ещё одно решение клика
// https://stackoverflow.com/questions/53877558/how-to-download-a-file-when-a-button-inside-a-recyclerview-is-pressed
//        val item = holder.bindGames(games[position])
////        val item: Game = getItem(position)
//        holder.getDataBinding().appButton.setOnClickListener(
//            View.OnClickListener {
//                val context: Context = (viewHolder as ViewHolder).RecyclerView.getContext()
//                val manager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
//                val request = DownloadManager.Request(Uri.parse(item.getDownloadUrl()))
//                request.setTitle(item.getTitle())
//                request.setDescription(item.getDescription())
//                request.setDestinationInExternalPublicDir(
//                    Environment.DIRECTORY_DOWNLOADS,
//                    item.getFileName()
//                )
//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
//                request.setVisibleInDownloadsUi(true)
//                manager.enqueue(request)
//            }
//        )

// TODO: Другое решение
// https://www.geeksforgeeks.org/how-to-download-file-from-url-in-android-programmatically-using-download-manager/

// TODO: Возможное решение
// https://www.youtube.com/watch?v=Vx-NY81Gpds
//            appButton.setOnClickListener() {
//                val context: Context = itemView.context
//                val manager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
//                val request = DownloadManager.Request(Uri.parse())
//                request.setDestinationInExternalPublicDir(
//                    Environment.DIRECTORY_DOWNLOADS,
//
//                    )
//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
//                request.setAllowedOverMetered(true)
//                manager.enqueue(request)
//            }