package com.example.sqlitedbdemo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var txtID: EditText
    private lateinit var txtName: EditText
    private lateinit var txtClassName: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button
    private lateinit var btnReadAll: Button
    private lateinit var btnRead: Button
    private lateinit var txtData: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtID = findViewById(R.id.txtID)
        txtName = findViewById(R.id.txtName)
        txtClassName = findViewById(R.id.txtClassName)
        btnAdd = findViewById(R.id.btnAdd)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
        btnReadAll = findViewById(R.id.btnReadAll)
        btnRead = findViewById(R.id.btnRead)
        txtData = findViewById(R.id.txtData)
        val dbAccess = StudentDatabaseHelper(applicationContext)
        btnAdd.setOnClickListener {
            val id = txtID.text.toString().toInt()
            val name = txtName.text.toString()
            val classname = txtClassName.text.toString()
            dbAccess.addStudent(id, name, classname)
            Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show()
            txtData.text = dbAccess.getAllStudents()
        }
        btnUpdate.setOnClickListener {
            val id = txtID.text.toString().toInt()
            val name = txtName.text.toString()
            val classname = txtClassName.text.toString()
            dbAccess.updateStudent(id, name, classname)
            Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show()
            txtData.text = dbAccess.getAllStudents()
        }
        btnDelete.setOnClickListener {
            val id = txtID.text.toString().toInt()
            dbAccess.deleteStudent(id)
            Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show()
            txtData.text = dbAccess.getAllStudents()
        }
        btnReadAll.setOnClickListener {
            txtData.text = dbAccess.getAllStudents()
        }
        // btnRead logic can be added as needed
    }
}
