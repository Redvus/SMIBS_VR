package com.redvus.smibsvirtual.presentation

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.redvus.smibsvirtual.*
import com.redvus.smibsvirtual.data.Project
import com.redvus.smibsvirtual.databinding.ActivityArealityBinding


class ARealityActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArealityBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout

//    private var buttonScanner: Button? = null
    private var buttonScanner: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArealityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.titleAR)
        setSupportActionBar(binding.toolbarMain)

        drawerLayout = binding.drawer
        drawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.toolbarMain,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        binding.apply {
            nv.setNavigationItemSelectedListener {
                when (it.itemId) {
//                    R.id.menu_action_main -> {
//                        startActivity(Intent(this@ARealityActivity, MainActivity::class.java))
//                    }
                    R.id.menu_action_ar -> {
                        startActivity(Intent(this@ARealityActivity, ARealityActivity::class.java))
                    }
                    R.id.menu_action_games -> {
                        startActivity(Intent(this@ARealityActivity, GamesActivity::class.java))
                    }
                    R.id.menu_action_about -> {
                        startActivity(Intent(this@ARealityActivity, AboutActivity::class.java))
                    }
                    R.id.menu_action_how -> {
                        startActivity(Intent(this@ARealityActivity, HowActivity::class.java))
                    }
                }
                true
            }
        }

        val listProjects = findViewById<RecyclerView>(R.id.resycler_projects)

        val projects: Array<Project> = arrayOf(
            Project(
                R.drawable.dav_board_giantbow,
                getString(R.string.davBowTitle),
                getString(R.string.davBowText)
            ),
            Project(
                R.drawable.dav_board_wing,
                getString(R.string.davWingTitle),
                getString(R.string.davWingText)
            ),
            Project(
                R.drawable.dav_board_calculator,
                getString(R.string.davCalculatorTitle),
                getString(R.string.davCalculatorText)
            ),
            Project(
                R.drawable.dav_board_mobile,
                getString(R.string.davMobileTitle),
                getString(R.string.davMobileText)
            ),
            Project(
                R.drawable.dav_board_excavator,
                getString(R.string.davExcavatorTitle),
                getString(R.string.davExcavatorText)
            ),
            Project(
                R.drawable.dav_board_parashute,
                getString(R.string.davParashuteTitle),
                getString(R.string.davParashuteText)
            ),
            Project(
                R.drawable.dav_board_clock,
                getString(R.string.davClockTitle),
                getString(R.string.davClockText)
            ),
            Project(
                R.drawable.dav_board_wheel,
                getString(R.string.davWheelTitle),
                getString(R.string.davWheelText)
            )
        )

        val adapterProjects = ARealityAdapter(projects)
        listProjects.adapter = adapterProjects

        buttonScanner = binding.buttonScanAr
        buttonScanner?.setOnClickListener {
            checkCameraPermission()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 5973)
        } else {
            startActivity(Intent(this, ARcameraActivity::class.java))
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 5973) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startActivity(Intent(this, ARcameraActivity::class.java))
            }
        }
    }
}