package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    MediaPlayer mp;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onCreate()
    {
        Toast.makeText(this,"Welcome",Toast.LENGTH_LONG).show();
        mp=MediaPlayer.create(this,R.raw.sample);
        mp.setLooping(true);
    }
    public void onStart(Intent i,int id)
    {
        Toast.makeText(this,"Service started",Toast.LENGTH_LONG).show();
        mp.start();
    }
    public void onDestroy()
    {
        Toast.makeText(this,"Service stopped",Toast.LENGTH_LONG).show();
        mp.stop();
    }
}
