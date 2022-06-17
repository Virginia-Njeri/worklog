package com.clarissa22.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.clarissa22.workoutlog.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_login)

        views()

    }

    fun validateLogin() {
        var email =binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is invalid"
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Email is invalid"

        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password required"
        }


    }

    fun views() {


            binding.btnLogin.setOnClickListener {
            validateLogin()
            startActivity(Intent(this, HomeActivity::class.java))
        }

                binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

}









