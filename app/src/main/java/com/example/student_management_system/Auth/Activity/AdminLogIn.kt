package com.example.student_management_system.Auth.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.student_management_system.HomeScreen.Activity.HomeScreen
import com.example.student_management_system.R
import com.example.student_management_system.databinding.ActivityAdminLogInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AdminLogIn : AppCompatActivity() {
    private lateinit var binding: ActivityAdminLogInBinding
    lateinit var mAuth: FirebaseAuth
    lateinit var firebaseDatabase: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_admin_log_in)
        setContentView(binding.root)

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.setStatusBarColor(this.getResources().getColor(R.color.transparent))
        mAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()

        binding.btnLogIn.setOnClickListener {
            mAuth.signInWithEmailAndPassword(
                binding.etUserId.text.toString(),
                binding.etPassword.text.toString()
            ).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val name: String = "khushal"
                    val id: String = task.result?.user?.uid.toString()
                    firebaseDatabase.getReference().child("Users").child(id)
                        .setValue(name)
                    val toast = Toast.makeText(
                        this,
                        "Sucessfull Account Creation",
                        Toast.LENGTH_SHORT
                    )
                    val intent = Intent(this, HomeScreen::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    val toast = Toast.makeText(
                        this,
                        "ERROR",
                        Toast.LENGTH_SHORT
                    )
                }
            }

        }
    }
}