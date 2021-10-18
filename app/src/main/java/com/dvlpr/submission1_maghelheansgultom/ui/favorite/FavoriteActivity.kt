package com.dvlpr.submission1_maghelheansgultom.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dvlpr.submission1_maghelheansgultom.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    private lateinit var favoriteBinding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(favoriteBinding.root)

        val favSectionPagerAdapter = FavSectionPagerAdapter(this, supportFragmentManager)
        favoriteBinding.apply {
            viewPager.adapter = favSectionPagerAdapter
            tabs.setupWithViewPager(favoriteBinding.viewPager)

            btnBack.setOnClickListener {
                this@FavoriteActivity.finish()
            }
        }
    }
}