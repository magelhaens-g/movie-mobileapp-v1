package com.dvlpr.submission1_maghelheansgultom.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.dvlpr.submission1_maghelheansgultom.databinding.ActivityMainBinding
import com.dvlpr.submission1_maghelheansgultom.ui.favorite.FavoriteActivity

class MainActivity : AppCompatActivity() {
    private var doubledBackPressed = false
    private val delay: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        activityMainBinding.apply {
            viewPager.adapter = sectionPagerAdapter
            tabs.setupWithViewPager(activityMainBinding.viewPager)

            btnFav.setOnClickListener {
                val intent = Intent(this@MainActivity, FavoriteActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onBackPressed() {
        if (doubledBackPressed) {
            super.onBackPressed()
            return
        }
        this.doubledBackPressed = true
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            doubledBackPressed = false
        }, delay)
    }
}