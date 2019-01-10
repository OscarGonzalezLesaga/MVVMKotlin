package com.gonzalez.oscar.loginmvvm.domain

import com.gonzalez.oscar.loginmvvm.data.Either
import com.gonzalez.oscar.loginmvvm.data.ErrorLogin
import com.gonzalez.oscar.loginmvvm.data.User

interface ILoginRepository {

    fun doLogin(user: String, password: String): Either<ErrorLogin, User>

    fun getUser()
}