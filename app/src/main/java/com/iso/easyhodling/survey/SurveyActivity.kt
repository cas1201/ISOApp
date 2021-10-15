package com.iso.easyhodling.survey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.iso.easyhodling.MainActivity
import com.iso.easyhodling.R

class SurveyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)
    }

    fun goToHome(view: View){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}