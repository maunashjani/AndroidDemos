package com.example.demo21;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        final TextView textView1 = (TextView) findViewById(R.id.textView1);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        progressBar.setVisibility(View.GONE);
        textView1.setVisibility(View.GONE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Set the progress status zero on each button click
                progressStatus = 0;

                progressBar.setVisibility(View.VISIBLE);
                textView1.setVisibility(View.VISIBLE);

                // Start the lengthy operation in a background thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(progressStatus < 100){
                            // Update the progress status
                            progressStatus +=1;

                            // Try to sleep the thread for 20 milliseconds
                            try{
                                Thread.sleep(1000);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }

                            // Update the progress bar
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(progressStatus);
                                    // Show the progress on TextView
                                    textView1.setText(progressStatus+"");
                                    // If task execution completed
                                    if(progressStatus == 100){
                                        // Hide the progress bar from layout after finishing task
                                        progressBar.setVisibility(View.GONE);
                                        // Set a message of completion
                                        textView1.setText("Operation completed...");
                                    }
                                }
                            });
                        }
                    }
                }).start(); // Start the operation

            }
        });

    }
}
