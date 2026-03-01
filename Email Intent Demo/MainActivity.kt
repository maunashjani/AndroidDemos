package com.example.demo15

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun sendEmail(v: android.view.View) {
        val txtEmailTo = findViewById<EditText>(R.id.txtEmailTo)
        val txtSubject = findViewById<EditText>(R.id.txtSubject)
        val txtMessage = findViewById<EditText>(R.id.txtMessage)
        val to = arrayOf(txtEmailTo.text.toString())
        val cc = arrayOf("")
        val subject = txtSubject.text.toString()
        val msg = txtMessage.text.toString()
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            data = Uri.parse("mailto:")
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, to)
            putExtra(Intent.EXTRA_CC, cc)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, msg)
        }
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."))
            finish()
        } catch (ex: android.content.ActivityNotFoundException) {
            Toast.makeText(this, "No email client app installed.", Toast.LENGTH_SHORT).show()
        }
    }
}
