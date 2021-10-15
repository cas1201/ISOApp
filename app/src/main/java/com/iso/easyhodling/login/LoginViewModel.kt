package com.iso.easyhodling.login

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.iso.easyhodling.R

class LoginViewModel: ViewModel() {

    fun loginChecker(context: Context, username: String, password: String): Boolean {
        if (username.isNotEmpty() || password.isNotEmpty())
        {
            Toast.makeText(context, R.string.login, Toast.LENGTH_SHORT).show() //inicio correcto
            return true
        }
        else {
            Toast.makeText(context, R.string.loginerror, Toast.LENGTH_SHORT).show() //inicio incorrecto
            return false
        }
    }

}