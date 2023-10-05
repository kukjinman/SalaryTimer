package com.example.salarytimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.salarytimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.bottomNav.setOnItemSelectedListener {item ->
            when(item.itemId){
                R.id.home -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentFrame, mainFragment())
                        .commit()
                }
                R.id.setting -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentFrame, settingFragment())
                        .commit()

                }
            }
            true
        }

    }
}