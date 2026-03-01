package com.example.demo17

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
    }
    fun dateCode(v: android.view.View) {
        val c = Calendar.getInstance()
        val mYear = c.get(Calendar.YEAR)
        val mMonth = c.get(Calendar.MONTH)
        val mDay = c.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth ->
            editText1.setText("${year}-${month + 1}-${dayOfMonth}")
        }, mYear, mMonth, mDay)
        datePickerDialog.show()
    }
    fun timeCode(v: android.view.View) {
        val c = Calendar.getInstance()
        val mHour = c.get(Calendar.HOUR_OF_DAY)
        val mMinute = c.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(this, { _, hourOfDay, minute ->
            editText2.setText("${hourOfDay}:${minute}")
        }, mHour, mMinute, false)
        timePickerDialog.show()
    }
}
