package com.iso.easyhodling.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.iso.easyhodling.R
import com.iso.easyhodling.databinding.ActivityLoginBinding
import com.iso.easyhodling.survey.SurveyActivity
import kotlin.math.log

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    fun goToMain(view: View){
        val username = binding.userText.text.toString()
        val password = binding.passwordText.text.toString()

        if (!loginViewModel.loginChecker(this, username, password)){
            Toast.makeText(this, R.string.loginerror_credentials, Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, R.string.login, Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, SurveyActivity::class.java))
        }
    }

    fun goToCreateAccount(view: View){
        startActivity(Intent(this, CreateAccountActivity::class.java))
    }
}