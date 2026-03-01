package com.example.demo13

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView1: TextView
    private lateinit var imageButton: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView1 = findViewById(R.id.textView1)
        registerForContextMenu(textView1)
        imageButton = findViewById(R.id.imageButton)
        imageButton.setOnClickListener {
            val popup = PopupMenu(this, imageButton)
            popup.menuInflater.inflate(R.menu.popupmenudemo, popup.menu)
            popup.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.option3 -> {
                        Toast.makeText(this, "Reply Clicked", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.option4 -> {
                        Toast.makeText(this, "Reply All Clicked", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        // ...existing code...
    }
}
