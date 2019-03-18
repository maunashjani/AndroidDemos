package com.example.demo15;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendEmail(View v) {

        EditText txtEmailTo = (EditText) findViewById(R.id. txtEmailTo );
        EditText txtSubject = (EditText) findViewById(R.id. txtSubject );
        EditText txtMessage = (EditText) findViewById(R.id. txtMessage );


        String[] TO = {txtEmailTo.getText().toString()};
        String[] CC = {""};
        String subject = txtSubject.getText().toString();
        String msg = txtMessage.getText().toString();


        Intent emailIntent = new Intent(Intent. ACTION_SEND);
        emailIntent.setData(Uri. parse ("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent. EXTRA_EMAIL , TO);
        emailIntent.putExtra(Intent. EXTRA_CC , CC);
        emailIntent.putExtra(Intent. EXTRA_SUBJECT , subject);
        emailIntent.putExtra(Intent. EXTRA_TEXT , msg);

        try {
            startActivity(Intent. createChooser (emailIntent, "Send mail..."));
            finish();
        }
        catch (android.content.ActivityNotFoundException ex)
        {
            Toast. makeText (MainActivity.this, "No email client app installed.", Toast. LENGTH_SHORT ).show();         }
        }
    }
