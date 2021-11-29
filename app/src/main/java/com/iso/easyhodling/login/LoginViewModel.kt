package com.iso.easyhodling.login

import android.content.Context
import androidx.lifecycle.ViewModel
import com.iso.easyhodling.DBConnect
import com.iso.easyhodling.ShPrefs
import java.lang.Exception
import java.lang.NullPointerException

class LoginViewModel: ViewModel() {

    lateinit var handler: DBConnect

    // Funcion para comprobar los datos introducidos para iniciar sesion con la base de datos
    fun loginChecker(context: Context, username: String, password: String): Int{
        handler = DBConnect(context)

        if (username.isEmpty() || password.isEmpty())
            return 0

        return if (handler.getUserFromDBLogin(username, password))
            2
        else
            1
    }

    fun binanceStarter(context: Context){
        try {
            ShPrefs(context).getBinance()
        }catch (e: NullPointerException){
             var coins = mutableMapOf("BTC" to 10, "ETH" to 10, "SHIB" to 1000, "THC" to 50000,
                "ADA" to 4000, "DOT" to 100, "SOL" to 300, "BNB" to 500, "LTC" to 1000)

            ShPrefs(context).saveBinance(coins)
        }

    }
}