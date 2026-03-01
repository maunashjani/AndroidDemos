package com.example.demo21

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var progressStatus = 0
    private val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val textView1 = findViewById<TextView>(R.id.textView1)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.GONE
        textView1.visibility = View.GONE
        button.setOnClickListener {
            progressStatus = 0
            progressBar.visibility = View.VISIBLE
            textView1.visibility = View.VISIBLE
            Thread {
                while (progressStatus < 100) {
                    progressStatus += 1
                    try {
                        Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    handler.post {
                        progressBar.progress = progressStatus
                        textView1.text = "Progress: $progressStatus%"
                    }
                }
            }.start()
        }
    }
}
