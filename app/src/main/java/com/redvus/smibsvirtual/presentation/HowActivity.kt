package com.redvus.smibsvirtual.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.text.HtmlCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.redvus.smibsvirtual.R
import com.redvus.smibsvirtual.databinding.ActivityHowBinding

class HowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHowBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.titleHow)
        setSupportActionBar(binding.toolbarMain)

        val drawerLayout: DrawerLayout = binding.drawer
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, binding.toolbarMain,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        binding.apply {
            nv.setNavigationItemSelectedListener {
                when(it.itemId) {
//                    R.id.menu_action_main -> {
//                        startActivity(Intent(this@HowActivity, MainActivity::class.java))
//                    }
                    R.id.menu_action_ar -> {
                        startActivity(Intent(this@HowActivity, ARealityActivity::class.java))
                    }
                    R.id.menu_action_games -> {
                        startActivity(Intent(this@HowActivity, GamesActivity::class.java))
                    }
                    R.id.menu_action_about -> {
                        startActivity(Intent(this@HowActivity, AboutActivity::class.java))
                    }
                    R.id.menu_action_how -> {
                        startActivity(Intent(this@HowActivity, HowActivity::class.java))
                    }
                    R.id.menu_action_about_app -> {
                        startActivity(Intent(this@HowActivity, AboutAppActivity::class.java))
                    }
                }
                true
            }
        }

        val longText = getString(R.string.textHow)
        val output: TextView = binding.textHow
        output.text = HtmlCompat.fromHtml(longText, HtmlCompat.FROM_HTML_MODE_LEGACY)
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