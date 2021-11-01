package com.iso.easyhodling.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.iso.easyhodling.EasyHodlingApp.Companion.prefs
import com.iso.easyhodling.R
import com.iso.easyhodling.databinding.ActivityLoginBinding
import com.iso.easyhodling.survey.SurveyActivity
import kotlin.math.log
import kotlin.properties.Delegates

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    // Funcion para el comportamiento del boton de entrar en la pantalla de login
    fun goToMain(view: View){
        val username = binding.userText.text.toString()
        val password = binding.passwordText.text.toString()

        /*
        Los valores que puede tomar la variable 'checkerresponse' son:
            0 =  los campos a rellenar de login estan vacios
            1 = los datos introducidos no son correctos
            2 = los datos introducidos son correctos
        */
        val checkerResponse = loginViewModel.loginChecker(this, username, password)
        loginResponse(checkerResponse)
    }

    // Funcion para el comportamiento del boton de crear cuenta en la pantalla de login
    fun goToCreateAccount(view: View){
        startActivity(Intent(this, CreateAccountActivity::class.java))
    }
    // Funcion para el comportamiento del boton de crear cuenta en la pantalla de login
    fun goToPasswordForgotten(view: View){
        startActivity(Intent(this, PasswordForgottenActivity::class.java))
    }

    // Funcion para el comportamiento del login cuando introduces los datos
    private fun loginResponse(logResponse: Int){
        when(logResponse){
            0 -> Toast.makeText(this, R.string.loginerror_blank, Toast.LENGTH_SHORT).show() //campos vacios
            1 -> Toast.makeText(this, R.string.loginerror_credentials, Toast.LENGTH_SHORT).show()
            2 -> {
                prefs.saveUsername(binding.userText.text.toString())
                prefs.saveEmail(binding.userText.text.toString())
                Toast.makeText(this, R.string.login, Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, SurveyActivity::class.java))
                finish()
            }
        }
    }
}