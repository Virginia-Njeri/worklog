package com.clarissa22.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.clarissa22.workoutlog.R
import com.clarissa22.workoutlog.apis.Apiclient
import com.clarissa22.workoutlog.apis.ApiInterface
import com.clarissa22.workoutlog.databinding.ActivitySignUpBinding
import com.clarissa22.workoutlog.model.RegisteResponse
import com.clarissa22.workoutlog.model.RegisterRequest
import com.clarissa22.workoutlog.viewModel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
    }

    override fun onResume() {
        super.onResume()
        userViewModel.registeresponsLiveData.observe(
            this,
            androidx.lifecycle.Observer { registerResponse ->
                Toast.makeText(baseContext, registerResponse.message, Toast.LENGTH_LONG).show()
                startActivity(Intent(baseContext, LoginActivity::class.java))
//                Toast.makeText(baseContext,registerResponse?.message,Toast.LENGTH_LONG).show()
            })
        userViewModel.registeresponsLiveData.observe(
            this,
            androidx.lifecycle.Observer { registerError ->
                Toast.makeText(baseContext, registerError, Toast.LENGTH_LONG).show()
//                Toast.makeText(baseContext, registerError, Toast.LENGTH_LONG).show()
            })
    }


    fun castViews() {
        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener {
            validateSignup()
        }
    }

    fun validateSignup() {

        binding.tilFirstName.error = null
        binding.tilLastName.error = null
        binding.tilEmail2.error = null
        binding.tilPassword2.error = null
        binding.tilPhonenumber.error = null
        binding.tilConfirmPassword.error = null
        var error = false
        var firstname = binding.etFirstName.text.toString()
        if (firstname.isBlank()) {
            binding.tilLastName.error = "First name is required"
            error = true
        }
        var secondname = binding.etFirstName.text.toString()
        if (secondname.isBlank()) {
            binding.tilLastName.error = "Last name is required"
            error = true
        }
        var email3 = binding.etEmail3.text.toString()
        if (email3.isBlank()) {
            binding.tilEmail2.error = "Email is required"
            error = true

        }
        var number = binding.etPhonenumber.text.toString()
        if (number.isBlank()) {
            binding.tilPhonenumber.error = "Email is required"
            error = true

        }
        var password2 = binding.etPassword2.text.toString()
        if (password2.isBlank()) {
            binding.tilPassword2.error = "Password is required"
            error = true

        }
        var confirm = binding.etConfirm.text.toString()
        if (confirm.isBlank()) {
            binding.tilConfirmPassword.error = "Confirmation is required"
            error = true

        }
//        if (!Pattern.EMAIL_ADDRESS.matcher(email3).matches()) {
//            binding.tilEmail2.error = "Not a valid email address"
//            error = true
//        }
        if (password2 != confirm) {
            binding.tilConfirmPassword.error = "password does not match"

        }
        if (!error) {
            val registerRequest = RegisterRequest(firstname, secondname, number, email3, password2)
            userViewModel.registerUser(registerRequest)

        }
    }
}