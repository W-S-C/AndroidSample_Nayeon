package com.android.project.weather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.project.weather.R
import com.android.project.weather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }


    private fun initBottomNavigation(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame_layout, OneFragment())
            .commitAllowingStateLoss()

        binding.mainBottomNavi.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.oneFragment ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame_layout, OneFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.twoFragment ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame_layout, TwoFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.threeFragment ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frame_layout, ThreeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}