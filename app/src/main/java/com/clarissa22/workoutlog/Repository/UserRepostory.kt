package com.clarissa22.workoutlog.Repository

import com.clarissa22.workoutlog.apis.Apiclient
import com.clarissa22.workoutlog.apis.ApiInterface
import com.clarissa22.workoutlog.model.LoginRequest
import com.clarissa22.workoutlog.model.LoginResponse
import com.clarissa22.workoutlog.model.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepostory {
    var apiClient = Apiclient.buildApiClient(ApiInterface::class.java)

   suspend fun loginUser (loginRequest: LoginRequest):Response<LoginResponse>
    = withContext(Dispatchers.IO){
       val response=apiClient.loginUser(loginRequest)
        return@withContext response
    }
    suspend fun registerUser(registerRequest: RegisterRequest)=
        withContext(Dispatchers.IO) {
            val request= apiClient.registerUser(registerRequest)
            return@withContext apiClient.registerUser(registerRequest)
        }
}
