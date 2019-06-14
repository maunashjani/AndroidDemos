package com.example.asynctaskdemo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView2 = (TextView) findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SimpleAsyncTask simpleTask = new SimpleAsyncTask();
                String sleepTime = editText.getText().toString();
                simpleTask.execute(sleepTime);

            }
        });

    }

    private class SimpleAsyncTask extends AsyncTask<String, String, String> {

        private String result;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... strings) {

            publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                int time = Integer.parseInt(strings[0])*1000;

                Thread.sleep(time);
                result = "Slept for " + strings[0] + " seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
                result = e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                result = e.getMessage();
            }
            return result;

        }

        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            progressDialog.dismiss();
            textView2.setText(result);
        }

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(MainActivity.this,
                    "Loading...",
                    "Wait for "+editText.getText().toString()+ " seconds");
        }

        @Override
        protected void onProgressUpdate(String... text) {
            textView2.setText(text[0]);

        }
    }


}
