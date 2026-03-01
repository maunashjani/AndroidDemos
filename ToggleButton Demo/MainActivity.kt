package com.example.demo5

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var toggleButton1: ToggleButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toggleButton1 = findViewById(R.id.toggleButton1)
        toggleButton1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Its On", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Its Off", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun changeText(v: android.view.View) {
        val textView1 = findViewById<TextView>(R.id.textView1)
        textView1.text = "Good Bye"
    }
}
