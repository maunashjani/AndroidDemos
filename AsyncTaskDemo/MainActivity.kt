package com.example.asynctaskdemo

import android.app.ProgressDialog
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        textView2 = findViewById(R.id.textView2)

        button.setOnClickListener {
            val sleepTime = editText.text.toString()
            SimpleAsyncTask().execute(sleepTime)
        }
    }

    inner class SimpleAsyncTask : AsyncTask<String, String, String>() {
        private var result: String = ""
        private var progressDialog: ProgressDialog? = null

        override fun doInBackground(vararg params: String): String {
            publishProgress("Sleeping...")
            return try {
                val time = params[0].toInt() * 1000
                Thread.sleep(time.toLong())
                "Slept for ${params[0]} seconds"
            } catch (e: Exception) {
                e.printStackTrace()
                e.message ?: "Error"
            }
        }
    }
}
