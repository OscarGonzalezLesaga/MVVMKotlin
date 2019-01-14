package com.gonzalez.oscar.loginmvvm.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gonzalez.oscar.loginmvvm.domain.ILoginRepository
import com.gonzalez.oscar.loginmvvm.presentation.ui.LoginViewModel

class LoginViewModelFactory(private val loginRespository: ILoginRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(loginRespository) as T
    }
}