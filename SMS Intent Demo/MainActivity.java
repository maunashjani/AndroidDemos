package com.example.demo14;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SendSMSCode(View v)
    {
        String phoneNumber = "MOBILE_NUMBER_HERE";
        String message = "Hello World! From Android Intent";

        Uri uri = Uri.parse("smsto:"+ phoneNumber);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", message);

        startActivity(intent);
    }
}
