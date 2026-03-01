package com.example.demo10

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val languages = arrayOf("Java", "JavaScript", "C", "C++", "C#", "Python", "PHP")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, languages)
        autoCompleteTextView.threshold = 1
        autoCompleteTextView.setAdapter(arrayAdapter)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, languages)
        spinner.adapter = adapter1
    }
}
