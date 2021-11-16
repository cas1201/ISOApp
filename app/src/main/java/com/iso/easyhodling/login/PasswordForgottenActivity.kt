package com.iso.easyhodling.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.iso.easyhodling.R
import com.iso.easyhodling.databinding.ActivityCreateAccountBinding
import com.iso.easyhodling.databinding.ActivityPasswordForgottenBinding
import java.util.regex.Pattern

class PasswordForgottenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordForgottenBinding
    private lateinit var passwordForgottenViewModel: PasswordForgottenViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordForgottenBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_password_forgotten)
        passwordForgottenViewModel= ViewModelProvider(this).get(PasswordForgottenViewModel::class.java)
    }
    fun onClick(view: View){

    }

    //validar si el email es válido
    fun validate(view: View){
        val email = binding.editTextTextEmailAddress.text.toString()

        if ((email.isEmpty()) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, R.string.correoinvalido, Toast.LENGTH_SHORT).show()
        }
        //sendEmail(email)

    }
    //para ir al login
    fun gotoLogin(view:View){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
    //https://firebase.google.com/docs/android/setup?hl=es PARA TERMINAR LO DE MANDAR EMAIL

    /*fun sendEmail(view: View){
        FirebaseAuth auth = FirebaseAuth.getInstance()
        val email = binding.editTextTextEmailAddress.text.toString()

        auth.sendPasswordResetEmail()
    } */

    //funcion de volver en caso de haber pinchado en recuperar contraseña sin querer en el login, hacer una función para el botón de back

}