package com.example.servicedemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val b1 = findViewById<Button>(R.id.b1)
        val b2 = findViewById<Button>(R.id.b2)
        val b3 = findViewById<Button>(R.id.b3)
        b1.setOnClickListener { b1click() }
        b2.setOnClickListener { b2click() }
        b3.setOnClickListener { b3click() }
    }
    private fun b1click() {
        startService(Intent(this, MyService::class.java))
    }
    private fun b2click() {
        stopService(Intent(this, MyService::class.java))
    }
    private fun b3click() {
        val i = Intent(this, SecondActivity::class.java)
        startActivity(i)
    }
}
