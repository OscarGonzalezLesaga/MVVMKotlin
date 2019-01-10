package com.gonzalez.oscar.loginmvvm.domain

import com.gonzalez.oscar.loginmvvm.data.Either
import com.gonzalez.oscar.loginmvvm.data.ErrorLogin
import com.gonzalez.oscar.loginmvvm.data.User

class LoginRepository : ILoginRepository {

    override fun doLogin(user: String, password: String): Either<ErrorLogin, User> {
        return when {
            user == "pollocampero" && password == "123456" -> Either.Success(User(user, password))
            else -> Either.Error(ErrorLogin.INVALID_LOGIN)
        }
    }

    override fun getUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}