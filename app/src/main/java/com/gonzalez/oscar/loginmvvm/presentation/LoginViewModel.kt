package com.gonzalez.oscar.loginmvvm.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gonzalez.oscar.loginmvvm.data.Either
import com.gonzalez.oscar.loginmvvm.data.ErrorLogin
import com.gonzalez.oscar.loginmvvm.data.User
import com.gonzalez.oscar.loginmvvm.domain.ILoginRepository

class LoginViewModel(private val loginRespository: ILoginRepository) : ViewModel() {

    fun validateUser(user: String, password: String): LiveData<Either<ErrorLogin, User>> {
        val result = MutableLiveData<Either<ErrorLogin, User>>()
        when {
            user.isNullOrEmpty() -> {
                result.value = Either.Error(ErrorLogin.USER_ERROR)
            }
            password.isNullOrEmpty() -> {
                result.value = Either.Error(ErrorLogin.PASSWORD_ERROR)
            }
            else -> {
                result.value = loginRespository.doLogin(user, password)
            }
        }

        return result
    }


}