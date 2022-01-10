package com.redvus.smibsvirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.redvus.smibsvirtual.databinding.ActivityGamesBinding
import com.redvus.smibsvirtual.presentation.*

class GamesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGamesBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamesBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        supportActionBar?.title = getString(R.string.titleGames)
        setSupportActionBar(binding.toolbarMain)

        val drawerLayout: DrawerLayout = binding.drawer
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, binding.toolbarMain, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        binding.apply {
            nv.setNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.menu_action_main -> {
                        startActivity(Intent(this@GamesActivity, MainActivity::class.java))
                    }
                    R.id.menu_action_ar -> {
                        startActivity(Intent(this@GamesActivity, ARealityActivity::class.java))
                    }
                    R.id.menu_action_about -> {
                        startActivity(Intent(this@GamesActivity, AboutActivity::class.java))
                    }
                    R.id.menu_action_how -> {
                        startActivity(Intent(this@GamesActivity, HowActivity::class.java))
                    }
                }
                true
            }
        }

        val list = findViewById<RecyclerView>(R.id.resycler_view_games)

        val games: Array<Game> = arrayOf(
            Game(
                R.drawable.smibsg_cosmicpuzzles
            ),
            Game(
                R.drawable.smibsg_igroskazy
            ),
            Game(
                R.drawable.smibsg_magicfeather
            ),
            Game(
                R.drawable.smibsg_oldappartment
            ),
            Game(
                R.drawable.smibsg_pasternak
            ),
            Game(
                R.drawable.smibsg_rilke
            ),
            Game(
                R.drawable.smibsg_siberiandraw
            ),
            Game(
                R.drawable.smibsg_smekailo
            )
        )

        val adapter = GamesAdapter(games)
        list.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.menu_main, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.menu_action_main -> {
//                startActivity(Intent(this, MainActivity::class.java))
//                return true
//            }
//            R.id.menu_action_ar -> {
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
}

data class Game(var image: Int)