package com.example.namdemo1

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val broadcastIntent = Intent(this, AlarmBroadcastReceiver::class.java)
        val pIntent = PendingIntent.getBroadcast(applicationContext, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmMgr = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            alarmMgr.set(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 3000,
                pIntent
            )
            Toast.makeText(this, "Alarm was set, please wait.", Toast.LENGTH_SHORT).show()
        }
    }
    fun dateForAlarm(): Long {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.SECOND, 3)
        return calendar.timeInMillis
    }
}
