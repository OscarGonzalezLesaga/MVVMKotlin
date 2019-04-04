package com.gonzalez.oscar.loginmvvm.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gonzalez.oscar.loginmvvm.data.Either
import com.gonzalez.oscar.loginmvvm.data.ErrorLogin
import com.gonzalez.oscar.loginmvvm.data.User
import com.gonzalez.oscar.loginmvvm.domain.ILoginRepository
import kotlinx.coroutines.*

class LoginViewModel(private val loginRespository: ILoginRepository) : ViewModel() {

    private var userLiveDataData = MutableLiveData<Either<ErrorLogin, User>>()

    val stateLogin: LiveData<Either<ErrorLogin, User>>
        get() =
            userLiveDataData

    fun validateUser(user: String, password: String) {
        when {
            user.isEmpty() -> {
                userLiveDataData.value = Either.Error(ErrorLogin.USER_ERROR)
            }
            password.isEmpty() -> {
                userLiveDataData.value = Either.Error(ErrorLogin.PASSWORD_ERROR)
            }
            else -> {
                GlobalScope.launch {
                    //simulate call WS async
                    userLiveDataData.postValue(loginRespository.doLogin(user, password).await())
                }
            }
        }
    }
}