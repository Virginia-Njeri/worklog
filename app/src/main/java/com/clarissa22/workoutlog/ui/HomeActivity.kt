package com.clarissa22.workoutlog.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clarissa22.workoutlog.R
import com.clarissa22.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_home)
        setUpButtomNav()


    }
    fun setUpButtomNav(){
       binding.bnvHome.setOnItemSelectedListener { item ->
           when(item.itemId){
               R.id.plan ->{
                   supportFragmentManager.beginTransaction().replace(R.id.fcvHome, PlanFragment())

                   true
               }
               R.id.profile ->{
                   supportFragmentManager.beginTransaction().replace(
                       R.id.fcvHome,
                       ProfileFragment()
                   ).commit()
                   true
               }
               R.id.track ->{
                   supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment()).commit()
                   true
               }


               else->false
           }
       }
    }

}