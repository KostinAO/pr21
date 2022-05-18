package com.example.pr48

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mIntent = PendingIntent.getActivity(applicationContext,1,
            Intent(this,Exercise::class.java),PendingIntent.FLAG_UPDATE_CURRENT)
        val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        findViewById<Button>(R.id.understand).setOnClickListener {
            am.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), 60*60*60, mIntent)
        }
        findViewById<Button>(R.id.enough).setOnClickListener {
            am.cancel(mIntent)
        }
    }
}