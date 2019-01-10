package com.gonzalez.oscar.loginmvvm.utilities

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.view.inputmethod.InputMethodManager


fun AppCompatActivity.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}

fun AppCompatActivity.hideKeyboard() {
    val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    //Find the currently focused view, so we can grab the correct window token from it.
    var view = this.currentFocus

    imm.hideSoftInputFromWindow(view!!.windowToken, 0)
}