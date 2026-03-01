package com.example.servicedemo

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class MyService : Service() {
    private var mp: MediaPlayer? = null
    override fun onBind(intent: Intent?): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }
    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show()
        mp = MediaPlayer.create(this, R.raw.sample)
        mp?.isLooping = true
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Service started", Toast.LENGTH_LONG).show()
        mp?.start()
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Service stopped", Toast.LENGTH_LONG).show()
        mp?.stop()
    }
}
