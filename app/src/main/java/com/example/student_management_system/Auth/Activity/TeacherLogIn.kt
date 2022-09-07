package com.example.student_management_system.Auth.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.student_management_system.R
import com.example.student_management_system.databinding.ActivityTeacherLogInBinding

class TeacherLogIn : AppCompatActivity() {

    private lateinit var binding:ActivityTeacherLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_teacher_log_in)
        setContentView(binding.root)


        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.setStatusBarColor(this.getResources().getColor(R.color.transparent))

        binding.orgbtn.setOnClickListener {

            val view = View.inflate(this, R.layout.dialog_organization, null)

            val builder = AlertDialog.Builder(this)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        }
        binding.tvHeading.setOnClickListener {
            if(binding.etUserId.text.toString()=="admin" && binding.etPassword.text.toString()=="admin"){
                val intent = Intent(this, AdminLogIn::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}