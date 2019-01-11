package com.gonzalez.oscar.loginmvvm.presentation

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
        get() = userLiveDataData

    fun validateUser(user: String, password: String) {
        when {
            user.isNullOrEmpty() -> {
                userLiveDataData.value = Either.Error(ErrorLogin.USER_ERROR)
            }
            password.isNullOrEmpty() -> {
                userLiveDataData.value = Either.Error(ErrorLogin.PASSWORD_ERROR)
            }
            else -> {
                GlobalScope.async {
                    //simulate call WS async
                    userLiveDataData.value = loginRespository.doLogin(user, password)
                }
            }
        }
    }
}