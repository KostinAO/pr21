package com.example.myapplication123

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var myIntent = Intent("com.example.myapplication.app.BORODINO")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.attendance).setOnClickListener {
            val stri = getResources().getString(R.string.broadcast)
            sendOrderedBroadcast(myIntent, null,  MyReceiver(),  null,   0,  "Borodino",
                Bundle().apply{
                    putString("strEx", stri)
                })
        }
    }
}

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        var res = getResultExtras(true)
        var str = res.getString("strEx")
        Toast.makeText(context, str, Toast.LENGTH_LONG).show()
    }
}
