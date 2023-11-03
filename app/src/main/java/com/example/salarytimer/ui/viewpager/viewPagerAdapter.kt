package com.example.salarytimer.ui.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.salarytimer.ui.MainActivity
import com.example.salarytimer.ui.fragments.mainpages.mainFragment
import com.example.salarytimer.ui.fragments.mainpages.mainFragment2
import com.example.salarytimer.ui.fragments.mainpages.mainFragment3

class ViewPagerAdapter(mainActivity: MainActivity) :
    FragmentStateAdapter(mainActivity) {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    val fragments = listOf<Fragment>(mainFragment(), mainFragment2(),mainFragment3())

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}