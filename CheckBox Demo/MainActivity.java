package com.example.demo6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);


        sum = 0;


        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    sum = sum + 100;

                    Toast.makeText(MainActivity.this, String.valueOf(sum), Toast.LENGTH_SHORT).show();
                }
                else
                {

                }
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    sum = sum + 100;
                    Toast.makeText(MainActivity.this, String.valueOf(sum), Toast.LENGTH_SHORT).show();
                }
                else
                {

                }
            }
        });
    }


    /*public void GetBill(View v)
    {

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);

        int sum = 0;

        if(checkBox1.isChecked())
        {
            sum = sum + 100;
        }

        if(checkBox2.isChecked())
        {
            sum = sum + 50;
        }

        Toast.makeText(this, sum, Toast.LENGTH_SHORT).show();

    }*/
}
