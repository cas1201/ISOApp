package com.iso.easyhodling.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.iso.easyhodling.R

class PasswordForgottenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_forgotten)
    }
    fun gotoLogin(view:View){
        //código para mandar email
        finish()

    }
}