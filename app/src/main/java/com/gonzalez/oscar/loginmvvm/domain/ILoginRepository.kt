package com.gonzalez.oscar.loginmvvm.domain

import com.gonzalez.oscar.loginmvvm.data.Either
import com.gonzalez.oscar.loginmvvm.data.ErrorLogin
import com.gonzalez.oscar.loginmvvm.data.User
import kotlinx.coroutines.Deferred

interface ILoginRepository {

    fun doLogin(user: String, password: String): Deferred<Either<ErrorLogin, User>>

    fun getUser()
}