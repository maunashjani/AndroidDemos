package com.example.namdemo1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent broadcastIntent = new Intent(this, AlarmBroadcastReceiver.class);

        // The Pending Intent to pass in AlarmManager
        final PendingIntent pIntent = PendingIntent.getBroadcast(getApplicationContext(),0, broadcastIntent,0);

        final AlarmManager alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alarmMgr.set(
                        AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis() + 3000,
                        pIntent);

                Toast.makeText(MainActivity.this, "Alarm was set, please wait.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public long dateForAlarm()
    {
        Calendar calendar = Calendar.getInstance();
        //calendar.timeInMillis = System.currentTimeMillis()
        //calendar.set(Calendar.HOUR_OF_DAY, 21)
        //calendar.set(Calendar.MINUTE, 13)
        calendar.set(Calendar.SECOND, 3);

        return calendar.getTimeInMillis();
    }
}
