package com.iso.easyhodling.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModelProvider
import com.iso.easyhodling.R
import com.iso.easyhodling.databinding.ActivityCreateAccountBinding
import java.lang.StringBuilder
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var createAccountViewModel: CreateAccountViewModel
    private lateinit var binding: ActivityCreateAccountBinding
    private lateinit var dbReference:DatabaseReference
    private lateinit var database:FirebaseDatabase
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createAccountViewModel = ViewModelProvider(this).get(CreateAccountViewModel::class.java)
    }

    // Funcion para el comportamiento del boton de crear cuenta en la pantalla de crear cuenta
    fun addUser(view: View) {

        val username = binding.usernameText.text.toString()
        val name = binding.nameText.text.toString()
        val surname = binding.surnameText.text.toString()
        val email = binding.emailText.text.toString()
        var password = binding.passwordText.text.toString()
        val passwordrepeat = binding.passwordrepText.text.toString()
        val passwordEncriptado = createAccountViewModel.getMD5(password)
        database= FirebaseDatabase.getInstance()
        auth= FirebaseAuth.getInstance()
        dbReference=database.reference.child("User")


        //comparar contraseñas al crear cuenta, tb se puede con equals
        if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, R.string.email_error, Toast.LENGTH_SHORT)
                .show()
            false
        }

        if (password == passwordrepeat) {

            if (createAccountViewModel.createUser(
                    this,
                    username,
                    name,
                    surname,
                    email,
                    passwordEncriptado,
                    passwordrepeat
                )
            ) {
               // auth.createUserWithEmailAndPassword(email, passwordrepeat).addOnCompleteListener(this){
                //    task ->
                 //   if (task.isComplete){
                   //     val user:FirebaseUser?=auth.currentUser
                     //   if (user != null) {
                       //     verificar(user)

                         //   val userBD=dbReference.child(user?.uid)
                           // userBD.child("User Name").setValue(username)
                            //userBD.child("Name").setValue(name)
                            //userBD.child("Surname").setValue(surname)
                            //userBD.child("email").setValue(email)
                            // userBD.child("Password").setValue(passwordrepeat)

                      //  }

                    //}
                }

                }

                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

// private fun verificar(user:FirebaseUser){
//   user.sendEmailVerification().addOnCompleteListener(this) {
//           task ->
//      if(task.isComplete){

//      }
// }

//  }
//}



