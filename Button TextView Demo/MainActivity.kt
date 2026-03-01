package com.example.demo2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var lblMessage: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button1)
        lblMessage = findViewById(R.id.lbl_message)
        button1.setOnClickListener {
            lblMessage.text = "Computer Science"
        }
    }
}
