    package com.example.todoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val listView = findViewById<ListView>(R.id.list_view_notes)
        val imageViewAdd = findViewById<ImageView>(R.id.iv_add)
        val preferences = getSharedPreferences("notes", Context.MODE_PRIVATE)
        val currentNotes = preferences.getString("myNotes", "").toString()

        val list = currentNotes.split("*").toTypedArray()
        val adapter = ArrayAdapter(this, R.layout.item_note, list)
        listView.adapter = adapter

        imageViewAdd.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }
}