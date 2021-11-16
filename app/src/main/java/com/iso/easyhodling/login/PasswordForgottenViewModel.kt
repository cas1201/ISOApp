package com.iso.easyhodling.login

import android.content.Context
import androidx.lifecycle.ViewModel
import com.iso.easyhodling.DBConnect

class PasswordForgottenViewModel: ViewModel() {

    lateinit var handler: DBConnect

    // Funcion para comprobar el email con la base de datos
    fun emailChecker(context: Context, email: String): Int{
        handler = DBConnect(context)

        if (email.isEmpty())
            return 0

        return if (handler.getUserFromDBLogin(email)) {
            2
        } else
            1
    }
}