package com.iso.easyhodling

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.iso.easyhodling.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashTimer(this)
    }

    private fun splashTimer(context: Context){
        object : CountDownTimer(2000, 1000){
            override fun onTick(millisUntilFinished: Long) {

            }

            @SuppressLint("HardwareIds")
            override fun onFinish() {
                val login = Intent(context, LoginActivity::class.java)
                startActivity(login)
                finish()
            }
        }.start()
    }
}