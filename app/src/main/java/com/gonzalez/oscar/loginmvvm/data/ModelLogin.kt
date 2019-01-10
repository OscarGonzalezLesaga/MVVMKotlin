package com.gonzalez.oscar.loginmvvm.data

data class User(val user: String, val password: String)

enum class ErrorLogin {
    USER_ERROR,
    PASSWORD_ERROR,
    INVALID_LOGIN
}