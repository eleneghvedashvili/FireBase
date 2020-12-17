package com.example.hm2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class PersonActivity : AppCompatActivity() {
    private lateinit var personInfoTextView : TextView
    private lateinit var logOutButton : Button
    private lateinit var passwordChangeButton : Button

    private lateinit var mAuth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        personInfoTextView = findViewById(R.id.personInfoTextView)
        logOutButton = findViewById(R.id.logOutButton)
        passwordChangeButton = findViewById(R.id.passwordChangeButton)

        personInfoTextView.text = mAuth.currentUser?.uid

        logOutButton.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            mAuth.signOut()
        }

        passwordChangeButton.setOnClickListener(){
            startActivity(Intent(this, PassworChangeActivity::class.java))
        }


    }
}