package com.iso.easyhodling

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class ShPrefs(val context: Context) {

    val SHARED_USER = "LoggedUser"
    val SHARED_USERNAME = "username"
    val SHARED_EMAIL = "email"
    val BINANCE = "BinanceMock"

    val storage = context.getSharedPreferences(SHARED_USER, 0)

    //---FUNCIONES PARA GUARDAR DATOS EN SHARED PREFERENCES
    // Funcion para guardar el nombre de usuario en las 'shared preferences'
    fun saveUsername(username: String){
        storage.edit().putString(SHARED_USERNAME, username).apply()
    }

    // Funcion para guardar el email en las 'shared preferences'
    fun saveEmail(email: String){
        storage.edit().putString(SHARED_EMAIL, email).apply()
    }

    // Funcion para guardar el mock de Binance
    fun saveBinance(binanceMap: MutableMap<String, Int>){
        val gson = Gson()
        val binanceMapString = gson.toJson(binanceMap)

        storage.edit().putString(BINANCE, binanceMapString).apply()
    }

    //---FUNCIONES PARA CARGAR DATOS DESDE SHARED PREFERENCES
    // Funcion para obtener el nombre de usuario de las 'shared preferences'
    fun getUsername(): String{
        return storage.getString(SHARED_USERNAME, "")!!
    }

    // Funcion para obtener el email de las 'shared preferences'
    fun getEmail(): String{
        return storage.getString(SHARED_EMAIL, "")!!
    }

    // Funcion para obtener el mock de Binance
    fun getBinance(): MutableMap<String, Int> {
        val gson = Gson()
        val binanceShPrefsString = storage.getString(BINANCE, "")!!

        val type: Type = object : TypeToken<MutableMap<String, Int>>() {}.type
        return gson.fromJson(binanceShPrefsString, type)
    }
}