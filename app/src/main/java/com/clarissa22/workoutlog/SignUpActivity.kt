package com.clarissa22.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
 lateinit var tilFirstName:TextInputLayout
 lateinit var etFirstName:TextInputEditText
 lateinit var tilLastName:TextInputLayout
 lateinit var etLastName:TextInputEditText
 lateinit var tilEmail2:TextInputLayout
 lateinit var etEmail3:TextInputEditText
 lateinit var tilPassword2:TextInputLayout
 lateinit var etPassword2:TextInputEditText
 lateinit var btnSignup:Button
 lateinit var tvLogin:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        tilFirstName=findViewById(R.id.tilFirstName)
        tilLastName=findViewById(R.id.tilLastName)
        etLastName=findViewById(R.id.etLastName)
        etFirstName=findViewById(R.id.etFirstName)
        etEmail3=findViewById(R.id.etEmail3)
        tilEmail2=findViewById(R.id.tilEmail2)
        tilPassword2=findViewById(R.id.tilPassword2)
        etPassword2=findViewById(R.id.etPassword2)
        btnSignup=findViewById(R.id.btnSignup)
        tvLogin=findViewById(R.id.tvLogin)

        btnSignup.setOnClickListener { validateSignup() }
        tvLogin.setOnClickListener {
            val intent= Intent(this,LoginActivity::class.java)
        }


    }
    fun validateSignup() {

        var firstname = etFirstName.text.toString()
        if (firstname.isBlank()) {
            tilFirstName.error = "First name is required"


        }

        var lastName = etLastName.text.toString()
        if (lastName.isBlank()) {
            tilLastName.error = "Last name is required"
        }

        var email=etEmail3.text.toString()
        if (email.isBlank()){
            tilEmail2.error="Email is required"
    }


        var password=etPassword2.text.toString()
        if (password.isBlank()){
            tilPassword2.error="Password is required"
             }



}}