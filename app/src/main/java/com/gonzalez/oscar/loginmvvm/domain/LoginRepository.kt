package com.gonzalez.oscar.loginmvvm.domain

import com.gonzalez.oscar.loginmvvm.data.Either
import com.gonzalez.oscar.loginmvvm.data.ErrorLogin
import com.gonzalez.oscar.loginmvvm.data.User
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class LoginRepository : ILoginRepository {

    override fun doLogin(user: String, password: String): Deferred<Either<ErrorLogin, User>> {
        return when {
            user == "pollocampero" && password == "123456" -> GlobalScope.async { Either.Success(User(user, password)) }
            else -> GlobalScope.async { Either.Error(ErrorLogin.INVALID_LOGIN) }
        }
    }

    override fun getUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}