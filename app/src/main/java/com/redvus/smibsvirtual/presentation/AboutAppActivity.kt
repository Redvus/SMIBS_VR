package com.redvus.smibsvirtual.presentation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.redvus.smibsvirtual.R
import com.redvus.smibsvirtual.databinding.ActivityAboutAppBinding

class AboutAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutAppBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain)

        drawerLayout = binding.drawer
        drawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.toolbarMain,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        binding.apply {
            nv.setNavigationItemSelectedListener {
                when (it.itemId) {
//                    R.id.menu_action_main -> {
//                        startActivity(Intent(this@AboutActivity, MainActivity::class.java))
//                    }
                    R.id.menu_action_ar -> {
                        startActivity(Intent(this@AboutAppActivity, ARealityActivity::class.java))
                    }
                    R.id.menu_action_games -> {
                        startActivity(Intent(this@AboutAppActivity, GamesActivity::class.java))
                    }
                    R.id.menu_action_about -> {
                        startActivity(Intent(this@AboutAppActivity, AboutActivity::class.java))
                    }
                    R.id.menu_action_how -> {
                        startActivity(Intent(this@AboutAppActivity, HowActivity::class.java))
                    }
                    R.id.menu_action_about_app -> {
                        startActivity(Intent(this@AboutAppActivity, AboutAppActivity::class.java))
                    }
                }
                true
            }
        }

        val textAboutAppDescription = getString(R.string.textAboutAppDescription)
        val output: TextView = binding.textAboutDescription
        output.text = textAboutAppDescription

        val aboutAppLink: TextView = binding.textAboutLink

        aboutAppLink.setOnClickListener() {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://smibs.ru")
            )
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}