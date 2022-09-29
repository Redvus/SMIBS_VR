package com.redvus.smibsvirtual.data

import android.content.Intent
import android.net.Uri

data class Game(var image: Int, var name: String, var description: String, var packageName: Int) {

    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(
            "https://play.google.com/store/apps/details?id=$packageName")
        setPackage("com.android.vending")
    }


//    startActivity(intent)

//    try {
//        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
//    } catch (e: ActivityNotFoundException) {
//        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
//    }
}

// Возможное решение клика на кнопке
// https://overcoder.net/q/4157/recyclerview-onclick

// Ссылка на Google Play
// https://stackoverflow.com/questions/11753000/how-to-open-the-google-play-store-directly-from-my-android-application
// https://developer.android.com/distribute/marketing-tools/linking-to-google-play?hl=he#android-app
//    try {
//        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
//    } catch (e: ActivityNotFoundException) {
//        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
//    }
