package com.clarissa22.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.clarissa22.workoutlog.Apiclient
import com.clarissa22.workoutlog.apis.ApiInterface
import com.clarissa22.workoutlog.databinding.ActivitySignUpBinding
import com.clarissa22.workoutlog.model.RegisteResponse
import com.clarissa22.workoutlog.model.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        var phoneNumber =binding.etPhonenumber.text.toString()
        if (phoneNumber.isBlank()){
            binding.tilPhonenumber.error = "please"
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
            val registerRequest = RegisterRequest(firstname,lastName,phoneNumber,email,password)
            makeRegisterRequest(registerRequest)
            startActivity(Intent(this,LoginActivity::class.java))


        }
    }
    fun makeRegisterRequest(registerRequest: RegisterRequest){
       val apiclient = Apiclient.buildApiClient(ApiInterface::class.java)
        val request = apiclient.registerUser(registerRequest)


        request.enqueue(object :Callback<RegisteResponse>{
            override fun onResponse(
                call: Call<RegisteResponse>,
                response: Response<RegisteResponse>) {
                if (response.isSuccessful){
                    Toast.makeText(baseContext,response.body()?.message,Toast.LENGTH_LONG).show()
                    //Navigate to Login
                }
                else{
                    val error= response.errorBody()?.string()
                    Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<RegisteResponse>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }

        })
    }
}