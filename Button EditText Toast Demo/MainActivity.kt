package com.example.demo3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var lblMessage: TextView
    private lateinit var editText1: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button1)
        lblMessage = findViewById(R.id.lbl_message)
        editText1 = findViewById(R.id.editText1)
    }
    fun clickDemo(v: View) {
        val s = editText1.text.toString()
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}
