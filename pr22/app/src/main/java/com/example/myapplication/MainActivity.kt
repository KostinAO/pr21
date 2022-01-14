package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val NCREATE=""
    val NSTART=""
    val NRESUME=""
    val NPAUSE=""
    val NSTOP=""
    val NRESTART=""
    val NDESTROY=""
    fun showMessage(s: String){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
        Log.d(NCREATE, s)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        showMessage("Activity CREATED")
    }
    fun showMessage1(s: String){
        val t=Toast.makeText(this,s,Toast.LENGTH_SHORT)
        t.setGravity(Gravity.CENTER, 0, 0)
        t.show()
        Log.d(NSTART, s)
    }
    override fun onStart() {
        super.onStart()
        //setContentView(R.layout.activity_main)
        showMessage1("Activity STARTED")
    }
    fun showMessage2(s: String){
        val toast2=Toast.makeText(this,s,Toast.LENGTH_SHORT)
        toast2.setGravity(Gravity.TOP, 0, 0)
        toast2.show()
        Log.d(NRESUME, s)
    }
    override fun onResume() {
        super.onResume()
        //setContentView(R.layout.activity_main)
        showMessage2("Activity RESUME")
    }
    fun showMessage3(s: String){
        val toast3=Toast.makeText(this,s,Toast.LENGTH_SHORT)
        toast3.setGravity(Gravity.RIGHT, 0, 0)
        toast3.show()
        Log.d(NPAUSE, s)
    }
    override fun onPause() {
        super.onPause()
        //setContentView(R.layout.activity_main)
        showMessage3("Activity PAUSE")
    }
    fun showMessage4(s: String){
        val toast4=Toast.makeText(this,s,Toast.LENGTH_SHORT)
        toast4.setGravity(Gravity.CENTER, 0, 0)
        toast4.show()
        Log.d(NSTOP, s)
    }
    override fun onStop() {
        super.onStop()
        //setContentView(R.layout.activity_main)
        showMessage4("Activity STOP")
    }
    fun showMessage5(s: String){
        val toast5=Toast.makeText(this,s,Toast.LENGTH_SHORT)
        toast5.setGravity(Gravity.FILL_HORIZONTAL, 0, 0)
        toast5.show()
        Log.d(NRESTART, s)
    }
    override fun onRestart() {
        super.onRestart()
        //setContentView(R.layout.activity_main)
        showMessage5("Activity RESTART")
    }
    fun showMessage6(s: String){
        val toast6=Toast.makeText(this,s,Toast.LENGTH_SHORT)
        toast6.setGravity(Gravity.FILL, 0, 0)
        toast6.show()
        Log.d(NDESTROY, s)
    }
    override fun onDestroy() {
        super.onDestroy()
        //setContentView(R.layout.activity_main)
        showMessage6("Activity DESTROYED")
    }
}
