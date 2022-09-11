package com.example.student_management_system.HomeScreen.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
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
        binding.toolbar.tbMain.title="Proj 1.0.0"



        val window: Window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.toolbar)


            }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.panelmenu -> {
                //Toast.makeText(applicationContext, "Upload Files", Toast.LENGTH_LONG).show()

                val view = View.inflate(this, R.layout.dialog_admin_panel, null)

                val builder = AlertDialog.Builder(this)
                builder.setView(view)

                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)


                true
            }
            else -> false
        }

        }}

