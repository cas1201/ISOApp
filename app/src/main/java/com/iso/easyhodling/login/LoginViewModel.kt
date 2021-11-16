package com.iso.easyhodling.login

import android.content.Context
import androidx.lifecycle.ViewModel
import com.iso.easyhodling.DBConnect

class LoginViewModel: ViewModel() {

    lateinit var handler: DBConnect

    // Funcion para comprobar los datos introducidos para iniciar sesion con la base de datos
    fun loginChecker(context: Context, username: String, password: String): Int{
        handler = DBConnect(context)

        if (username.isEmpty() || password.isEmpty())
            return 0

        return if (handler.getUserFromDBLogin(username))
            2
        else
            1
    }
}