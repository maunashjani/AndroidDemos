package com.example.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val log = "Action: ${intent.action}\nURI: ${intent.toUri(Intent.URI_INTENT_SCHEME)}\n"
        Toast.makeText(context, log, Toast.LENGTH_LONG).show()
    }
}
