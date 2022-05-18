package com.example.myapplication

import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.BatteryManager
import android.content.IntentFilter
import android.content.BroadcastReceiver
import android.content.Context;
import android.view.View
import android.widget.TextView;
import android.widget.Toast
import android.content.pm.PackageManager

import android.content.ComponentName




var time = 0
class MainActivity : AppCompatActivity() {
    companion object {
        var ins: MainActivity? = null
        fun getInstance(): MainActivity? {
            return ins
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ins = this
        setContentView(R.layout.activity_main);
        registerReceiver(TimeTickReciever(), IntentFilter("android.intent.action.TIME_TICK"))
        try {
            getInstance()?.updateTheTextView("время созерцания: 0 мин.")
        } catch (e: Exception) {
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(TimeTickReciever())
    }

    fun cancel_wait(view: View) {
        Toast.makeText(applicationContext, R.string.toast_text, Toast.LENGTH_LONG).show()
        onDestroy()
    }

    fun updateTheTextView(t: String) {
        this@MainActivity.runOnUiThread {
            val textV1 = findViewById<TextView>(R.id.print)
            textV1.text = t
        }
    }

    class TimeTickReciever : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            time += 1
            val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val batteryPct: Float? = level * 100 / scale.toFloat()
            if (batteryPct!! <= 20) {
                try {
                    getInstance()?.updateTheTextView("накормите Ждуна, силы на исходе!")
                } catch (e: Exception) {
                }
                }
            else {
                try {
                    getInstance()?.updateTheTextView("время созерцания: " + time + " мин.")
                } catch (e: Exception) {
                }
            }
            }
        }
}