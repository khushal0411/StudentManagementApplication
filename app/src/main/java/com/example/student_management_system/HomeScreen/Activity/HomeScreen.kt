package com.example.student_management_system.HomeScreen.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.student_management_system.R
import com.example.student_management_system.databinding.ActivityHomeScreenBinding
import java.util.*

class HomeScreen : AppCompatActivity() {
    private lateinit var binding:ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar.tbMain)
        Objects.requireNonNull(supportActionBar)!!.setDisplayShowTitleEnabled(false)
        binding.toolbar.tbMain.title=getString(R.string.app_name)
    }
}