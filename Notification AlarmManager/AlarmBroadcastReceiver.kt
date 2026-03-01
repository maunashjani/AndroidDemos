package com.example.namdemo1

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationCompat

class AlarmBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "c1"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nChannel = NotificationChannel(channelId, "NOTIFICATION_CHANNEL_NAME", NotificationManager.IMPORTANCE_HIGH)
            nChannel.enableLights(true)
            notificationManager.createNotificationChannel(nChannel)
        }
        val mBuilder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Alarm")
            .setContentText("Alarm ringing...wake up...")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        val id = (System.currentTimeMillis() / 1000).toInt()
        notificationManager.notify(id, mBuilder.build())
        val mp = MediaPlayer.create(context, R.raw.sample)
        //mp.start() // Uncomment to play sound
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show()
    }
}
