package com.example.todoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextUsername = findViewById<EditText>(R.id.et_username)
        val editTextPassword = findViewById<EditText>(R.id.et_password)
        val buttonLogin = findViewById<Button>(R.id.et_login)
        val textViewRegister = findViewById<TextView>(R.id.et_kayıtol)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()
            val preference = getSharedPreferences("users", Context.MODE_PRIVATE)
            val pass = preference.getString(username, "")

            if (pass == password){
                Toast.makeText(this,"Tebrikler, giriş yapıldı", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ListActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Kullanıcı Adı veya Şifre hatalı", Toast.LENGTH_SHORT).show()
            }
        }

        //register sayfasına yönlendirdik
        textViewRegister.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }
    }
}