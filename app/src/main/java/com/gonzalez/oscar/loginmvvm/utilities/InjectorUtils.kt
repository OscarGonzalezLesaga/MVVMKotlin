package com.gonzalez.oscar.loginmvvm.utilities

import androidx.lifecycle.ViewModelProvider
import com.gonzalez.oscar.loginmvvm.domain.LoginRepository
import com.gonzalez.oscar.loginmvvm.presentation.factory.LoginViewModelFactory

object InjectorUtils {
    fun provideLoginViewModelFactory(): ViewModelProvider.NewInstanceFactory {
        return LoginViewModelFactory(LoginRepository())
    }
}