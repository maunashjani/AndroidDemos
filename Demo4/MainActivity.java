package com.example.demo4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void secondScreenCode(View v)
    {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        intent.putExtra("NAME", "Mithibai");

        startActivity(intent);
    }
}
