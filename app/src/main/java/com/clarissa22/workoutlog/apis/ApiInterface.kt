package com.clarissa22.workoutlog.apis

import com.clarissa22.workoutlog.model.LoginRequest
import com.clarissa22.workoutlog.model.LoginResponse
import com.clarissa22.workoutlog.model.RegisteResponse
import com.clarissa22.workoutlog.model.RegisterRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisteResponse>

@POST("/login")
   suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>
}