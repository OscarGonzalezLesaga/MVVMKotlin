package com.gonzalez.oscar.loginmvvm.presentation

import android.view.View
import androidx.lifecycle.Observer
import com.gonzalez.oscar.loginmvvm.R
import com.gonzalez.oscar.loginmvvm.data.ErrorLogin
import com.gonzalez.oscar.loginmvvm.data.User
import com.gonzalez.oscar.loginmvvm.presentation.base.BaseActivity
import com.gonzalez.oscar.loginmvvm.utilities.InjectorUtils
import com.gonzalez.oscar.loginmvvm.utilities.hideKeyboard
import com.gonzalez.oscar.loginmvvm.utilities.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun getViewModelFactory() = InjectorUtils.provideLoginViewModelFactory()

    override fun getLayout() = R.layout.activity_login

    override fun onResume() {
        super.onResume()
        getViewModel<LoginViewModel>().stateLogin.observe(this, Observer {
            it.either(::manageError, ::manageCorrectLogin)
        })
    }

    fun loginButtonClicked(v: View) {
        hideKeyboard()
        getViewModel<LoginViewModel>().validateUser(username.text.toString(), password.text.toString())
    }

    private fun manageCorrectLogin(user: User) {
        toast("Welcome ${user.user}")
    }

    private fun manageError(error: ErrorLogin) {
        when (error) {
            ErrorLogin.USER_ERROR -> toast(getString(R.string.user_empty))
            ErrorLogin.PASSWORD_ERROR -> toast(getString(R.string.password_empty))
            ErrorLogin.INVALID_LOGIN -> toast(getString(R.string.error_login))
        }
    }
}
