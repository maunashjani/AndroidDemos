package com.example.sharedpreferencesdemo

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var txtUsername: EditText
    private lateinit var txtPhoneNo: EditText
    private lateinit var btnSave: Button
    private lateinit var btnDisplay: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtUsername = findViewById(R.id.editText3)
        txtPhoneNo = findViewById(R.id.editText4)
        btnSave = findViewById(R.id.button3)
        btnDisplay = findViewById(R.id.button4)
        btnSave.setOnClickListener { save() }
        btnDisplay.setOnClickListener { display() }
    }
    private fun save() {
        val sp = getSharedPreferences("Userdata", MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("username", txtUsername.text.toString())
        editor.putString("phoneno", txtPhoneNo.text.toString())
        editor.apply()
    }
    private fun display() {
        val sp = getSharedPreferences("Userdata", MODE_PRIVATE)
        Toast.makeText(this, sp.getString("username", ""), Toast.LENGTH_SHORT).show()
        Toast.makeText(this, sp.getString("phoneno", ""), Toast.LENGTH_SHORT).show()
    }
}
