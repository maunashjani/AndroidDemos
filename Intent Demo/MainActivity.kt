package com.example.demo4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun secondScreenCode(v: View) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("NAME", "XYZ")
        startActivity(intent)
    }
}
