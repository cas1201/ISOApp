package com.iso.easyhodling.login

import android.content.Context
import androidx.lifecycle.ViewModel
import com.iso.easyhodling.DBConnect
import com.iso.easyhodling.ShPrefs
import java.lang.Exception
import java.lang.NullPointerException
import java.lang.StringBuilder
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class LoginViewModel: ViewModel() {

    lateinit var handler: DBConnect

    // Funcion para comprobar los datos introducidos para iniciar sesion con la base de datos
    fun loginChecker(context: Context, username: String, password: String): Int{
        handler = DBConnect(context)

        if (username.isEmpty() || password.isEmpty())
            return 0

        return if (handler.getUserFromDBLogin(username, getMD5(password)))
            2
        else
            1
    }

    fun getMD5(s: String): String {
        try {
            val digest = MessageDigest.getInstance("MD5")
            digest.update(s.toByteArray())
            val messageDigest = digest.digest()
            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) hexString.append(Integer.toHexString(0xFF and aMessageDigest.toInt()))
            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }
}