package com.dvlpr.submission1_maghelheansgultom.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dvlpr.submission1_maghelheansgultom.R
import com.dvlpr.submission1_maghelheansgultom.ui.favorite.movie.FavMovieFragment
import com.dvlpr.submission1_maghelheansgultom.ui.favorite.tvshow.FavTvShowFragment

class FavSectionPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        private const val totalTab = 2

        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tv_show)
    }

    override fun getCount(): Int = totalTab

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavMovieFragment()
            1 -> FavTvShowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(
        TAB_TITLES[position])
}