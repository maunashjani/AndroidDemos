package com.example.demo11

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView1 = findViewById<ListView>(R.id.listView1)
        val data = arrayOf(
            "C", "C++", "Java", "VB.NET", "C#", "Node.js", "JavaScript", "HTML",
            "CSS", "PHP"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        listView1.adapter = adapter
        listView1.setOnItemClickListener { _, _, i, l ->
            val currentData = listView1.getItemAtPosition(i).toString()
            Toast.makeText(this, currentData, Toast.LENGTH_SHORT).show()
            Toast.makeText(this, l.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
