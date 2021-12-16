package com.iso.easyhodling.login

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.firebase.auth.FirebaseAuth
import com.iso.easyhodling.R
import com.iso.easyhodling.databinding.ActivityPasswordForgottenBinding

class PasswordForgottenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordForgottenBinding
    private lateinit var passwordForgottenViewModel: PasswordForgottenViewModel
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordForgottenBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_password_forgotten)
        passwordForgottenViewModel =
            ViewModelProvider(this).get(PasswordForgottenViewModel::class.java)
        // INCLUIR EL BOTON
        // editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress)

    }

    //validar si el email es válido
    fun validate(view: View) {
        val emailaddress = binding.editTextTextEmailAddress.text.toString()

        if ((emailaddress.isEmpty()) || !Patterns.EMAIL_ADDRESS.matcher(emailaddress).matches()) {
            Toast.makeText(this, R.string.correoinvalido, Toast.LENGTH_SHORT).show()
        }
        passwordForgottenViewModel.sendEmail(this, emailaddress)
    }

    /* para ir al login, TAMBIÉN VALDRÍA ESTA OPCIÓN
     fun gotoLogin(view:View){
         startActivity(Intent(this, LoginActivity::class.java))
         finish()
     }
     //https://firebase.google.com/docs/android/setup?hl=es PARA TERMINAR LO DE MANDAR EMAIL

 */


//-------------------OTRA FORMA DE HACERLO---------------------//
/* fun sendEmail(view: View){
        FirebaseAuth auth = FirebaseAuth.getInstance()
        val email = binding.editTextTextEmailAddress.text.toString()

        auth.sendPasswordResetEmail()
    }
   // función para la verificación
   fun sendEmailVerification() {

        val user = auth.currentUser!!
        user.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                // manda la verificación del email
            }
   }*/

    //funcion de volver en caso de haber pinchado en recuperar contraseña sin querer en el login, hacer una función para el botón de back

}


