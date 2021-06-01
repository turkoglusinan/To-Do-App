package com.example.todoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val editTextUsername = findViewById<EditText>(R.id.et_username)
        val editTextPassword = findViewById<EditText>(R.id.et_password)
        val buttonLogin = findViewById<Button>(R.id.et_register)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()
            //shared preference de key ve value olarak tutulur(key,value) ->("abc",123)
            val preference = getSharedPreferences("users", Context.MODE_PRIVATE)
            val editor = preference.edit()
            editor.putString(username, password).apply()

            Toast.makeText(this, "Tebrikler, kaydınız oluşturuldu.", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}