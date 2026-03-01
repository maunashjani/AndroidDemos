package com.example.demo6

import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var sum = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val checkBox1 = findViewById<CheckBox>(R.id.checkBox1)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        checkBox1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sum += 100
                Toast.makeText(this, sum.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        checkBox2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sum += 100
                Toast.makeText(this, sum.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
