package com.example.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername;
    EditText txtPhoneNo;
    Button btnSave, btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtUsername = (EditText)  findViewById(R.id.editText3);

        txtPhoneNo = (EditText) findViewById(R.id.editText4);

        btnSave = (Button) findViewById(R.id.button3);

        btnDisplay = (Button) findViewById(R.id.button4);


    }


    public void Save(View v)
    {

        //Write data to SP
        SharedPreferences sp = getSharedPreferences("Userdata", MODE_PRIVATE);

        SharedPreferences.Editor editor  = sp.edit();

        editor.putString("username", txtUsername.getText().toString());
        editor.putString("phoneno", txtPhoneNo.getText().toString());

        editor.commit();
    }

    public void Display(View v)
    {

        //Read from SP
        SharedPreferences sp = getSharedPreferences("Userdata", MODE_PRIVATE);
        Toast.makeText(this, sp.getString("username", ""), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, sp.getString("phoneno", ""), Toast.LENGTH_SHORT).show();

    }

}
