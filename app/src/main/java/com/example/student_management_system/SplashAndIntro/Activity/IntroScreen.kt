package com.example.student_management_system.SplashAndIntro.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import com.example.student_management_system.Auth.Activity.StudentLogIn
import com.example.student_management_system.Auth.Activity.TeacherLogIn
import com.example.student_management_system.R

class IntroScreen : AppCompatActivity() {

    private lateinit var stubtn : Button
    private lateinit var teabtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_screen)

        stubtn = findViewById(R.id.stubtn)
        teabtn = findViewById(R.id.teabtn)

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.setStatusBarColor(this.getResources().getColor(R.color.transparent))

        stubtn.setOnClickListener {

            val intent = Intent(this, StudentLogIn::class.java)
            startActivity(intent)

        }

        teabtn.setOnClickListener {

            val intent = Intent(this, TeacherLogIn::class.java)
            startActivity(intent)

        }



    }
}