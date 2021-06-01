package com.example.todoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val editText = findViewById<EditText>(R.id.et_note)
        val button = findViewById<Button>(R.id.btn_add)

        button.setOnClickListener {
            val note = editText.text.toString()
            val preferences = getSharedPreferences("notes", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            val myNotes = preferences.getString("myNotes","")

            if (myNotes == ""){
                editor.putString("myNotes",note).apply()
            }
            else{
                val newNotes = myNotes.plus("*").plus(note)
                editor.putString("myNotes", newNotes).apply()
            }
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}