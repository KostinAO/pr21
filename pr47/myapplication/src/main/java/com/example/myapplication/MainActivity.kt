package com.example.myapplication

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val Студент1=Студент1()
    val Студент2=Студент2()
    val Студент3=Студент3()
    val Студент4=Студент4()
    val Студент5=Студент5()
    val Студент6=Студент6()
    val intentFilter = IntentFilter("com.example.myapplication.app.BORODINO")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(Студент1, intentFilter)
        registerReceiver(Студент2, intentFilter)
        registerReceiver(Студент3, intentFilter)
        registerReceiver(Студент4, intentFilter)
        registerReceiver(Студент5, intentFilter)
        registerReceiver(Студент6, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(Студент1)
        unregisterReceiver(Студент2)
        unregisterReceiver(Студент3)
        unregisterReceiver(Студент4)
        unregisterReceiver(Студент5)
        unregisterReceiver(Студент6)
    }
}