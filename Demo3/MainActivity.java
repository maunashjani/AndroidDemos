package com.example.demo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declare variables/objects
    Button button1;
    TextView lbl_message;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define/assign
        button1 = (Button) findViewById(R.id.button1);
        lbl_message = (TextView) findViewById(R.id.lbl_message);
        editText1 = (EditText) findViewById(R.id.editText1);


        /*button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbl_message.setText("Computer Science");
            }
        });*/
    }

    public void clickDemo(View v)
    {
        //Log.d("Demo3App", "Our Message Here...");
        //lbl_message.setText("Computer Science");
        //Toast.makeText(this, "This is CS", Toast.LENGTH_LONG).show();

        String s = editText1.getText().toString();
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();


    }
}
