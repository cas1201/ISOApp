package com.iso.easyhodling.login

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.iso.easyhodling.DBConnect
import com.iso.easyhodling.R

class LoginViewModel: ViewModel() {

    lateinit var handler: DBConnect

    fun loginChecker(context: Context, username: String, password: String): Boolean{
        handler = DBConnect(context)

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, R.string.loginerror_blank, Toast.LENGTH_SHORT)
                .show() //campos vacios
            return false
        }

        return handler.getUserFromDBLogin(username, password)
    }
}