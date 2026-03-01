package com.example.demo7

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun getRadioValue(view: View) {
        val radioButton1 = findViewById<RadioButton>(R.id.radioButton1)
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        if (radioButton1.isChecked) {
            Toast.makeText(this, "Male Selected", Toast.LENGTH_SHORT).show()
        }
        if (radioButton2.isChecked) {
            Toast.makeText(this, "Female Selected", Toast.LENGTH_SHORT).show()
        }
    }
}
