package com.redvus.smibsvirtual.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.redvus.smibsvirtual.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        supportActionBar?.title = "Главная"
        supportActionBar?.hide()
        initMainMenuButtons()
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.menu_main, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.main_item_menu_1 -> {
//                startActivity(Intent(this, MainActivity::class.java))
//                return true
//            }
//            R.id.main_item_menu_2 -> {
//                startActivity(Intent(this, ARealityActivity::class.java))
//                return true
//            }
//            R.id.menu_action_about -> {
//                startActivity(Intent(this, AboutActivity::class.java))
//                return true
//            }
//            R.id.menu_action_how -> {
//                startActivity(Intent(this, HowActivity::class.java))
//                return true
//            }
//            R.id.menu_action_games -> {
//                startActivity(Intent(this, GamesActivity::class.java))
//                return true
//            }
//
//        }
//        return super.onOptionsItemSelected(item)
//    }

    private fun initMainMenuButtons() = with(binding) {
        mainItemMenu1.setOnClickListener {
            startActivity(Intent(this@MainActivity, ARealityActivity::class.java))
        }

        mainItemMenu2.setOnClickListener {
            startActivity(Intent(this@MainActivity, GamesActivity::class.java))
        }

        mainItemMenu3.setOnClickListener {
            startActivity(Intent(this@MainActivity, AboutActivity::class.java))
        }

        mainItemMenu4.setOnClickListener {
            startActivity(Intent(this@MainActivity, HowActivity::class.java))
        }

        mainItemMenu5.setOnClickListener {
            startActivity(Intent(this@MainActivity, AboutAppActivity::class.java))
        }
    }

}