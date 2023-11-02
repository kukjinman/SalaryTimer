package com.example.salarytimer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.salarytimer.R
import com.example.salarytimer.ui.viewpager.ViewPagerAdapter
import com.example.salarytimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.viewPager2.adapter = ViewPagerAdapter(this)

    }
}