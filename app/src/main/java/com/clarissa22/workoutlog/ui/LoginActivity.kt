package com.clarissa22.workoutlog.ui


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.clarissa22.workoutlog.model.LoginRequest
import com.clarissa22.workoutlog.model.LoginResponse
import com.clarissa22.workoutlog.databinding.ActivityLoginBinding
import com.clarissa22.workoutlog.viewModel.UserViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    lateinit var sharedPrefs:SharedPreferences
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
        sharedPrefs = getSharedPreferences("WORKOUT_PREFERNCES", MODE_PRIVATE)
    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginResponsLiveData.observe(this,{loginResponse->
            Toast.makeText(baseContext,loginResponse?.message,Toast.LENGTH_LONG).show()
        saveLoginDetail(loginResponse)
            startActivity(Intent(baseContext,HomeActivity::class.java))
        })
        userViewModel.errorLiveData.observe(this,{ errorMessage ->
            Toast.makeText(baseContext,errorMessage,Toast.LENGTH_LONG).show()

        })
    }
    fun castViews(){
        binding.btnLogin.setOnClickListener { validateLogin()
            startActivity(Intent(this, HomeActivity::class.java))


        }

        binding.tvSignup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))

        }

    }

     fun validateLogin(){
        var error = false
//        tilEmail.error=null
        binding.tilPassword.error=null
        var email = binding.etEmail.text.toString()
        if (email.isBlank()){
            binding.tilEmail.error="Email is required"
            error= true
        }
        var Password = binding.etPassword.text.toString()
        if (Password.isBlank()){
            binding.tilPassword.error="Password is required"
            error = error
        }
        if (!error){
            val loginRequest= LoginRequest(email,Password)
            onResume()
            binding.pbLogin.visibility = View.GONE
        }


    }

        fun saveLoginDetail(loginResponse: LoginResponse){
            val editor = sharedPrefs.edit()
            editor.putString("ACCESSTOKEN",loginResponse.accessToken)
            editor.putString("USER_ID",loginResponse.userId)
            editor.putString("PROFILE_ID",loginResponse.profileId)
            editor.apply()




        }
    }














