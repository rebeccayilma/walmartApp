package com.rebecca.walmartapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    val users = arrayListOf<User>(
        User("ree","ziz","reeeziz@123.com","pass"),
        User("abd","ree","abd@123.com","pass1"),
        User("laz","iz","laz@123.com","pass2"),
        User("re","cca","re@123.com","pass3"),
        User("zizu","la","zizu@123.com","pass4")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailET : EditText = findViewById(R.id.EmailAddressET)
        val passET : EditText = findViewById(R.id.PasswordET)

        val email : String = emailET.text.toString()
        val password : String = passET.text.toString()

        val signInbtn : Button = findViewById(R.id.signin_btn)
        signInbtn.setOnClickListener {
            val intent = Intent(this,ShoppingCart::class.java)
            startActivity(intent)
        }

    }
}