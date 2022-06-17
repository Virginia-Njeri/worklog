package com.clarissa22.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.clarissa22.workoutlog.databinding.ActivitySignUpBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener { validateSignup() }


    }

    fun validateSignup() {

        var firstname = binding.etFirstName.text.toString()
        if (firstname.isBlank()) {
            binding.tilFirstName.error = "First name is required"


        }

        var lastName = binding.etLastName.text.toString()
        if (lastName.isBlank()) {
            binding.tilLastName.error = "Last name is required"
        }

        var email = binding.etEmail3.text.toString()
        if (email.isBlank()) {
            binding.tilEmail2.error = "Email is required"
        }


        var password = binding.etPassword2.text.toString()
        if (password.isBlank()) {
            binding.tilPassword2.error = "Password is required"
        }
        var confirm = binding.etConfirm.text.toString()
        if (confirm.isBlank()) {
            binding.tilConfirmPassword.error = "Confirm password is required"
            if (password != confirm) {
                binding.tilConfirmPassword.error = "password does not match"
            }


        }
    }
}