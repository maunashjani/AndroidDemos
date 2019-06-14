package com.example.demo10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        String[] languages = { "Java", "JavaScript", "C", "C++", "C#", "Python", "PHP" };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, languages);

        autoCompleteTextView.setThreshold(1);

        autoCompleteTextView.setAdapter(arrayAdapter);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, languages);

        spinner.setAdapter(adapter1);



    }
}
