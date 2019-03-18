package com.example.sqlitedbdemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class StudentDatabaseHelper extends SQLiteOpenHelper {

    private final static String DB_NAME="StudentsDatabase.db";
    private final static String TABLE_NAME="student";
    private final static int DB_VERSION = 1;

    public StudentDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query= "CREATE TABLE student (ID INTEGER PRIMARY KEY, Name TEXT, ClassName TEXT);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            //
    }

    public void addStudent(int id, String name, String classname)
    {
        SQLiteDatabase db = getWritableDatabase();

       String query = "insert into student (ID,Name,ClassName) values (" + id+ ", '" + name + "','" + classname + "')";
        db.execSQL(query);

        db.close();

    }

    public void updateStudent(int id, String name, String classname)
    {
        SQLiteDatabase db = getWritableDatabase();

        String query = "update student set Name='"+name+"',ClassName='"+classname+"' where ID="+id;
        db.execSQL(query);

        db.close();
    }

    public void deleteStudent(int id)
    {
        SQLiteDatabase db = getWritableDatabase();

        String query = "delete from student where ID="+id;
        db.execSQL(query);
    }

    public String getAllStudents()
    {
        //Here, result variable will hold the data fetched from the Db
        String result="";

        //To Fetch the Data from the Table we use a Cursor object
        //and SQLiteDataBase  object.

        SQLiteDatabase db = getWritableDatabase();

        String query = "select * from student";
        Cursor c = db.rawQuery(query, null);

        //Move the cursor position to the first position of records.
        // c.moveToFirst();

        while (c.moveToNext())
        {
            //here 0 is ID, 1 is Name, 2 is ClassName
            //from the student table stored as values in
            //the cursor object c
            result +=c.getInt(0) + "\n";
            result +=c.getString(1) + "\n";
            result +=c.getString(2) + "\n";
        }
        db.close();

        return result;
    }

    public String getStudentById(int id)
    {
        //Here, result variable will hold the data fetched from the Db
        String result="";

        //To Fetch the Data from the Table we use a Cursor object
        //and SQLiteDataBase  object.

        SQLiteDatabase db = getWritableDatabase();

        String query = "select * from student where ID="+id;
        Cursor c = db.rawQuery(query, null);

        //Move the cursor position to the first position of record.

        if(c.moveToFirst())
        {
            result +=c.getInt(0) + "\n";
            result +=c.getString(1) + "\n";
            result +=c.getString(2) + "\n";
        }
        else
        {
            result = "No Record Found";
        }

        db.close();

        return result;
    }

}
