package com.iso.easyhodling.login

import android.content.Context
import androidx.lifecycle.ViewModel

class PasswordForgottenViewModel: ViewModel() {

    fun sendEmail(context: Context, emailaddress: String) {



        /*auth= FirebaseAuth.getInstance()
            val email = binding.editTextTextEmailAddress.text.toString()
            val addOnCompleteListener = auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Correo enviado!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    } else Toast.makeText(this, "Correo invalido!", Toast.LENGTH_SHORT).show()
                }

             */
    }
}