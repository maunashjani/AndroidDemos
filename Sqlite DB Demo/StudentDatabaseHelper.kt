package com.example.sqlitedbdemo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class StudentDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        private const val DB_NAME = "StudentsDatabase.db"
        private const val TABLE_NAME = "student"
        private const val DB_VERSION = 1
    }
    override fun onCreate(db: SQLiteDatabase) {
        val query = "CREATE TABLE student (ID INTEGER PRIMARY KEY, Name TEXT, ClassName TEXT);"
        db.execSQL(query)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database upgrade as needed
    }
    fun addStudent(id: Int, name: String, classname: String) {
        writableDatabase.use { db ->
            val query = "insert into student (ID,Name,ClassName) values ($id, '$name','$classname')"
            db.execSQL(query)
        }
    }
    fun updateStudent(id: Int, name: String, classname: String) {
        writableDatabase.use { db ->
            val query = "update student set Name='$name',ClassName='$classname' where ID=$id"
            db.execSQL(query)
        }
    }
    fun deleteStudent(id: Int) {
        writableDatabase.use { db ->
            val query = "delete from student where ID=$id"
            db.execSQL(query)
        }
    }
    fun getAllStudents(): String {
        readableDatabase.use { db ->
            val cursor = db.rawQuery("select * from student", null)
            val sb = StringBuilder()
            while (cursor.moveToNext()) {
                sb.append("ID: ${cursor.getInt(0)}, Name: ${cursor.getString(1)}, ClassName: ${cursor.getString(2)}\n")
            }
            cursor.close()
            return sb.toString()
        }
    }
}
