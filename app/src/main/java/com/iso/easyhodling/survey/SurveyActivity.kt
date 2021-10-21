package com.iso.easyhodling.survey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.iso.easyhodling.MainActivity
import com.iso.easyhodling.R

class SurveyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)
    }

    fun goToHome(view: View){
        startActivity(Intent(this, MainActivity::class.java))
        Toast.makeText(this, R.string.testsave, Toast.LENGTH_SHORT).show()
        finish()

    }
}