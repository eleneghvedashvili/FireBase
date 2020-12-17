package com.example.hm2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {

    private lateinit var inputEmail : EditText
    private lateinit var inputPassword : EditText
    private lateinit var registrationButton: Button

    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        mAuth = FirebaseAuth.getInstance()

        inputEmail = findViewById(R.id.singUpEditText)
        inputPassword = findViewById(R.id.singInPasswordEditText)
        registrationButton = findViewById(R.id.singUpButton)


        registrationButton.setOnClickListener(){
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Empty!",Toast.LENGTH_LONG).show()
            } else {
                mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener{ task ->
                        if (task.isSuccessful){
                            startActivity(Intent(this,MainActivity::class.java))
                            finish()
                        } else{
                            Toast.makeText(this,"Error!",Toast.LENGTH_LONG).show()
                        }
                    }

            }

        }
    }
}