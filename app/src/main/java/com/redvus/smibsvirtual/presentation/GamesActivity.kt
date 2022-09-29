package com.redvus.smibsvirtual.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.redvus.smibsvirtual.R
import com.redvus.smibsvirtual.data.Game
import com.redvus.smibsvirtual.databinding.ActivityGamesBinding

class GamesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGamesBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.titleGames)
        setSupportActionBar(binding.toolbarMain)

        val drawerLayout: DrawerLayout = binding.drawer
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, binding.toolbarMain,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        //Main menu
        binding.apply {
            nv.setNavigationItemSelectedListener {
                when(it.itemId) {
//                    R.id.menu_action_main -> {
//                        startActivity(Intent(this@GamesActivity, MainActivity::class.java))
//                    }
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

        // List of games
        val list = findViewById<RecyclerView>(R.id.resycler_view_games)
        val games: Array<Game> = arrayOf(
            Game(
                R.drawable.smibsg_cosmicpuzzles,
                getString(R.string.titleCosmicPuzzles),
                getString(R.string.textCosmicPuzzles),
                R.string.packageCosmicPuzzles
            ),
            Game(
                R.drawable.smibsg_igroskazy,
                getString(R.string.titleIgroskazi),
                getString(R.string.textIgroskazi),
                R.string.packageIgroskazy
            ),
            Game(
                R.drawable.smibsg_magicfeather,
                getString(R.string.titleMagicfeather),
                getString(R.string.textMagicfeather),
                R.string.packageMagicfeather
            ),
            Game(
                R.drawable.smibsg_oldappartment,
                getString(R.string.titleOldappartment),
                getString(R.string.textOldappartment),
                R.string.packageOldappartment
            ),
            Game(
                R.drawable.smibsg_pasternak,
                getString(R.string.titlePasternak),
                getString(R.string.textPasternak),
                R.string.packagePasternak
            ),
            Game(
                R.drawable.smibsg_rilke,
                getString(R.string.titleRilke),
                getString(R.string.textRilke),
                R.string.packageRilke
            ),
            Game(
                R.drawable.smibsg_siberiandraw,
                getString(R.string.titleSiberiandraw),
                getString(R.string.textSiberiandraw),
                R.string.packageSiberiandraw
            ),
            Game(
                R.drawable.smibsg_smekailo,
                getString(R.string.titleSmekailo),
                getString(R.string.textSmekailo),
                R.string.packageSmekailo
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

}