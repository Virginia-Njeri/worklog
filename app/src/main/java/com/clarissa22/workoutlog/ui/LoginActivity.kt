package com.clarissa22.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.clarissa22.workoutlog.R
import com.clarissa22.workoutlog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        views()

    }

    fun views() {


        binding.btnLogin.setOnClickListener {
            validateLogin()
        }

        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    fun validateLogin() {

        var error=false
        binding.tilEmail.error = null
        binding.tilPassword.error = null
        var email =binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is invalid"
            error=true
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Email is invalid"

        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password required"
            error=true
        }
        if (!error){
            startActivity(Intent(this,HomeActivity::class.java))
        }


    }



}









