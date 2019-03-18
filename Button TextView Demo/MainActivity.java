package com.example.demo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declare variables/objects
    Button button1;
    TextView lbl_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define/assign
        button1 = (Button) findViewById(R.id.button1);
        lbl_message = (TextView) findViewById(R.id.lbl_message);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbl_message.setText("Computer Science");
            }
        });


    }
}
