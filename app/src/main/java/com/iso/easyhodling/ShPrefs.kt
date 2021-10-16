package com.iso.easyhodling

import android.content.Context

class ShPrefs(val context: Context) {

    val SHARED_USER = "LoggedUser"
    val SHARED_USERNAME = "username"
    val SHARED_EMAIL = "email"

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

    //---FUNCIONES PARA CARGAR DATOS DESDE SHARED PREFERENCES
    // Funcion para obtener el nombre de usuario de las 'shared preferences'
    fun getUsername(): String{
        return storage.getString(SHARED_USERNAME, "")!!
    }

    // Funcion para obtener el email de las 'shared preferences'
    fun getEmail(): String{
        return storage.getString(SHARED_EMAIL, "")!!
    }
}