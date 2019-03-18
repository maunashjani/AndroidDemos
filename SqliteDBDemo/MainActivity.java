package com.example.sqlitedbdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText txtID, txtName, txtClassName;
    Button btnAdd, btnUpdate, btnDelete, btnReadAll, btnRead;
    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtID = (EditText) findViewById(R.id.txtID);
        txtName = (EditText) findViewById(R.id.txtName);
        txtClassName = (EditText) findViewById(R.id.txtClassName);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnReadAll = (Button) findViewById(R.id.btnReadAll);
        btnRead = (Button) findViewById(R.id.btnRead);

        txtData = (TextView) findViewById(R.id.txtData);

        final StudentDatabaseHelper dbAccess = new StudentDatabaseHelper(this.getApplicationContext());

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(txtID.getText().toString());
                String name = txtName.getText().toString();
                String classname = txtClassName.getText().toString();

                dbAccess.addStudent(id, name, classname);

                Toast.makeText(MainActivity.this, "Data Added", Toast.LENGTH_SHORT).show();

                txtData.setText(dbAccess.getAllStudents());
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(txtID.getText().toString());
                String name = txtName.getText().toString();
                String classname = txtClassName.getText().toString();

                dbAccess.updateStudent(id, name, classname);

                Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();

                txtData.setText(dbAccess.getAllStudents());
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(txtID.getText().toString());

                dbAccess.deleteStudent(id);

                Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();

                txtData.setText(dbAccess.getAllStudents());
            }
        });


        btnReadAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                txtData.setText(dbAccess.getAllStudents());

            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int id = Integer.parseInt(txtID.getText().toString());

                txtData.setText(dbAccess.getStudentById(id));

            }
        });
    }
}
