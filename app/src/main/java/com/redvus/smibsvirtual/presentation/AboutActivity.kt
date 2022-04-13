package com.redvus.smibsvirtual.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.redvus.smibsvirtual.*
import com.redvus.smibsvirtual.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setSupportActionBar(binding.toolbarMain)

        drawerLayout = binding.drawer
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, binding.toolbarMain,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        binding.apply {
            nv.setNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.menu_action_main -> {
                        startActivity(Intent(this@AboutActivity, MainActivity::class.java))
                    }
                    R.id.menu_action_ar -> {
                        startActivity(Intent(this@AboutActivity, ARealityActivity::class.java))
                    }
                    R.id.menu_action_games -> {
                        startActivity(Intent(this@AboutActivity, GamesActivity::class.java))
                    }
                    R.id.menu_action_about -> {
                        startActivity(Intent(this@AboutActivity, AboutActivity::class.java))
                    }
                    R.id.menu_action_how -> {
                        startActivity(Intent(this@AboutActivity, HowActivity::class.java))
                    }
                }
                true
            }
        }

        val longText = getString(R.string.article_pushkin_stih)
        val output: TextView = binding.textAbout
        output.text = longText

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