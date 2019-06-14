package com.example.demo7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GetRadioValue(View view)
    {
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);

        if(radioButton1.isChecked())
        {
            Toast.makeText(this, "Male Selected", Toast.LENGTH_SHORT).show();
        }

        if(radioButton2.isChecked())
        {
            Toast.makeText(this, "Female Selected", Toast.LENGTH_SHORT).show();
        }

    }
}
