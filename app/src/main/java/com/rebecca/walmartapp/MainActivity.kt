package com.rebecca.walmartapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var users = arrayListOf<User>(
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

        val intnt = getIntent()
        val fn = intnt.getStringExtra("fn").toString()
        val ln = intnt.getStringExtra("ln").toString()
        val em = intnt.getStringExtra("em").toString()
        val ps = intnt.getStringExtra("ps").toString()
        users.add(User(fn, ln, em, ps))



        val signInbtn : Button = findViewById(R.id.signin_btn)
        signInbtn.setOnClickListener {
            val email : String = emailET.text.toString()
            val password : String = passET.text.toString()

            val userem = users.filter{ it.email == email }
            val userpass = users.filter{ it.password == password }
            if (userem.isNotEmpty() && userpass.isNotEmpty()){
                val intent = Intent(this,ShoppingCart::class.java)
                intent.putExtra("uemail",email)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_LONG).show()
            }
        }

        val forgot :TextView = findViewById(R.id.forgotTV)
        forgot.setOnClickListener {
            val email : String = emailET.text.toString()
            val password : String = passET.text.toString()
            val userem = users.filter{ it.email == email }
            if (userem.isNotEmpty()){
                val uri = Uri.parse("mailto:${userem.get(0).email}")
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.setData(uri)
                intent.putExtra(Intent.EXTRA_TEXT, password)
                    startActivity(intent);

            }

        }

        val newAccountBtn : Button = findViewById(R.id.newacc_btn)
        newAccountBtn.setOnClickListener {
            val i = Intent(this, newAccount::class.java)
            startActivity(i)
        }

    }
}