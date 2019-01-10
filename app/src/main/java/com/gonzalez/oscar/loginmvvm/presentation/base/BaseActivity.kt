package com.gonzalez.oscar.loginmvvm.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
    }

    inline fun <reified T : ViewModel> getViewModel(): T =
        ViewModelProviders.of(this, getViewModelFactory()).get(T::class.java)

    abstract fun getViewModelFactory(): ViewModelProvider.NewInstanceFactory

    abstract fun getLayout(): Int
}