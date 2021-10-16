package com.iso.easyhodling.login

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.iso.easyhodling.DBConnect
import com.iso.easyhodling.R

class CreateAccountViewModel: ViewModel() {

    lateinit var handler: DBConnect

    fun createUser(context: Context, username: String, name: String,
    surname: String, email: String, password: String): Boolean{
        handler = DBConnect(context)

        return if (username == "" || name == "" || surname == "" || email == "" || password == ""){
            Toast.makeText(context, R.string.sign_up_blank, Toast.LENGTH_SHORT).show()
            false
        } else{
            if (handler.getUserFromDBCreate(username, email)) {
                Toast.makeText(context, R.string.loginerror_existing_user, Toast.LENGTH_SHORT)
                    .show()
                false
            } else {
                handler.addUserToDB(context, username, name, surname, email, password)
                Toast.makeText(context, R.string.user_created, Toast.LENGTH_SHORT).show()
                true
            }
        }
    }
}