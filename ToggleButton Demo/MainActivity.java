package com.example.demo5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    ToggleButton toggleButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);

        toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Toast.makeText(MainActivity.this, "Its On", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Its Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void ChangeText(View v)
    {
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText("Good Bye");
    }
}
