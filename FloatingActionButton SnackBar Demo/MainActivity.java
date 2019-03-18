package com.example.demo19;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void DemoCode(View v){
        //Toast.makeText(this, "Hello Class", Toast.LENGTH_SHORT).show();

        Snackbar.make(v, "Hello Class", Snackbar.LENGTH_LONG).setAction("Action", null).show();

    }
}
