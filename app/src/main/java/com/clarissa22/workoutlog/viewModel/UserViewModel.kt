package com.clarissa22.workoutlog.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clarissa22.workoutlog.Repository.UserRepostory
import com.clarissa22.workoutlog.model.LoginRequest
import com.clarissa22.workoutlog.model.LoginResponse
import com.clarissa22.workoutlog.model.RegisteResponse
import com.clarissa22.workoutlog.model.RegisterRequest
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    val userRepository= UserRepostory()
    val loginResponsLiveData=MutableLiveData<LoginResponse>()
    val errorLiveData = MutableLiveData<String>()
    var registeresponsLiveData=MutableLiveData<RegisteResponse>()
    val registerErrorLiveData = MutableLiveData<String?>()




    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response = userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                loginResponsLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
    fun registerUser(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            val response = userRepository.registerUser(registerRequest)
            if (response.isSuccessful) {
                registeresponsLiveData.postValue(response.body())
            } else {
                val error = response.errorBody()?.string()
                registerErrorLiveData.postValue(error)
            }
        }
    }


}


