package com.example.servicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1,b2,b3;
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
    }

    public void b1click(View v)
    {
        startService(new Intent(this,MyService.class));
    }
    public void b2click(View v)
    {
        stopService(new Intent(this,MyService.class));
    }
    public void b3click(View v)
    {
        Intent i=new Intent(this,SecondActivity.class);
        startActivity(i);
    }

}
