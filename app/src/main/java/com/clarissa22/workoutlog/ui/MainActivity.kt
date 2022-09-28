package com.clarissa22.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var shared: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shared= getSharedPreferences("WORKOUT_PREFERNCES", MODE_PRIVATE)
        val accessToken = shared.getString("ACCESS_TOKEN","")
        if (accessToken!!.isBlank()){
            startActivity(Intent(this, LoginActivity::class.java))

        }
        else{
        startActivity(Intent(this, HomeActivity::class.java))
         }

    }
}