package com.iso.easyhodling

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

class DBConnect(context: Context) : SQLiteOpenHelper(context, dbname, factory, version) {

    companion object{
        val dbname = "EasyHodlingDB"
        val factory = null
        val version = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE usuario(nombreUsuario varchar(15) primary key not null," +
                "nombre varchar(20) not null," +
                "apellidos varchar(40)," +
                "email varchar(40) not null unique," +
                "password varchar(15) not null)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    // Funcion para añadir un nuevo usuario a la base de datos
    fun addUserToDB (context: Context, name: String, surname: String, username: String,
                     email: String, password: String){
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()

        values.put("nombreUsuario", username)
        values.put("nombre", name)
        values.put("apellidos", surname)
        values.put("email", email)
        values.put("password", password)

        db.insert("usuario", null, values)
        db.close()
    }

    // Funcion para comprobar los datos de un usuario que intenta iniciar sesion
    fun getUserFromDBLogin(username: String, password: String): Boolean {
        val db: SQLiteDatabase = readableDatabase
        val query = "SELECT nombreUsuario, password FROM usuario WHERE " +
                "nombreUsuario = '${username}' and password = '${password}'"
        val cursor = db.rawQuery(query, null)

        if (cursor.count <= 0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

    // Funcion para comprobar si ya existe un usuario cuando se crea una cuenta nueva
    fun getUserFromDBCreateAccount(username: String, email: String): Boolean {
        val db: SQLiteDatabase = readableDatabase
        val query = "SELECT nombreUsuario, email FROM usuario WHERE " +
                "nombreUsuario = '${username}' and email = '${email}'"
        val cursor = db.rawQuery(query, null)

        if (cursor.count <= 0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
}