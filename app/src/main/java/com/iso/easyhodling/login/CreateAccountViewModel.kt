package com.iso.easyhodling.login

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import com.iso.easyhodling.DBConnect
import com.iso.easyhodling.R
import java.lang.StringBuilder
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class CreateAccountViewModel: ViewModel() {

    lateinit var handler: DBConnect

    // Funcion para crear un nuevo usuario con los datos introducidos en la base de datos
    fun createUser(
        context: Context, username: String, name: String,
        surname: String, email: String, password: String, passwordrepeat: String
    ): Boolean{
        handler = DBConnect(context)

        return if (username == "" || name == "" || surname == "" || email == "" || password == ""){
            Toast.makeText(context, R.string.sign_up_blank, Toast.LENGTH_SHORT).show()
            false
        } else{
            return if (handler.getUserFromDBCreateAccount(username, email)) {
                Toast.makeText(context, R.string.loginerror_existing_user, Toast.LENGTH_SHORT)
                    .show()
                false
            } else if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(context, R.string.email_error, Toast.LENGTH_SHORT)
                    .show()
                false
            } else {
                handler.addUserToDB(context, username, name, surname, email, password)
                Toast.makeText(context, R.string.user_created, Toast.LENGTH_SHORT).show()
                true
            }
        }
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