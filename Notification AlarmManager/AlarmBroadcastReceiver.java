package com.example.namdemo1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class AlarmBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "c1")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Alarm")
                .setContentText("Alarm ringing...wake up...")
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        /*if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            NotificationChannel nChannel = new NotificationChannel("c1", "NOTIFICATION_CHANNEL_NAME", NotificationManager.IMPORTANCE_HIGH);
            nChannel.enableLights(true);
            assert notificationManager != null;
            mBuilder.setChannelId("c1");
            notificationManager.createNotificationChannel(nChannel);
        }*/
        assert notificationManager != null;

        // Generate an Id for each notification
        int id = (int) (System.currentTimeMillis()/1000);

        notificationManager.notify(id, mBuilder.build());

        MediaPlayer mp;
        mp=MediaPlayer.create(context, R.raw.sample);
        //mp.start();

        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();
    }
}
