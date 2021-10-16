package com.iso.easyhodling.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.iso.easyhodling.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var createAccountViewModel: CreateAccountViewModel
    private lateinit var binding: ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createAccountViewModel = ViewModelProvider(this).get(CreateAccountViewModel::class.java)
    }

    fun addUser(view: View){

        val username = binding.usernameText.text.toString()
        val name = binding.nameText.text.toString()
        val surname = binding.surnameText.text.toString()
        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()

        if (createAccountViewModel.createUser(this, username, name, surname, email, password))
            startActivity(Intent(this, LoginActivity::class.java))
    }
}