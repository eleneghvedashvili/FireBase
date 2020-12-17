package com.example.hm2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetActivity : AppCompatActivity() {

    private lateinit var emailEditText : TextView
    private lateinit var  sendButton : Button

    private lateinit var mAuth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)

        mAuth = FirebaseAuth.getInstance()
        sendButton = findViewById(R.id.sendButton)
        emailEditText = findViewById(R.id.emailEditText)


        sendButton.setOnClickListener(){

            val email = emailEditText.text.toString()
            if (email.isEmpty()){
                Toast.makeText(this,"Empty!",Toast.LENGTH_SHORT)
            }else{
                mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener{ task ->
                       if (task.isSuccessful) {
                           startActivity(Intent(this,MainActivity::class.java))
                           finish()
                       } else{
                           Toast.makeText(this,"Error!",Toast.LENGTH_SHORT).show()
                       }
                }
            }

        }

    }

}