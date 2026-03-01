package com.example.demo19

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun demoCode(v: android.view.View) {
        Snackbar.make(v, "Hello Class", Snackbar.LENGTH_LONG).setAction("Action", null).show()
    }
}
