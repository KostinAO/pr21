package com.example.pr411

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.media.RingtoneManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.pr411.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var db: ActivityMainBinding
    lateinit var sm: SensorManager
    var lSensor: Sensor? = null
    var rSensor: Sensor? = null
    var aSensor: Sensor? = null
    var dataSensor:String = ""
    var s1: String = ""
    var s2: String = ""
    var s3: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = DataBindingUtil.setContentView(this,R.layout.activity_main)
        sm = getSystemService(SENSOR_SERVICE) as SensorManager
        db.l.isChecked = true
    }
    override fun onResume() {
        super.onResume()

        rSensor = sm.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
        if(rSensor !=null)
            sm.registerListener(this,rSensor,SensorManager.SENSOR_DELAY_GAME)
        else Toast.makeText(applicationContext,R.string.sensorAbsentL,Toast.LENGTH_SHORT).show()

        lSensor = sm.getDefaultSensor(Sensor.TYPE_LIGHT)
        if(lSensor !=null)
            sm.registerListener(this,lSensor,SensorManager.SENSOR_DELAY_GAME)
        else Toast.makeText(applicationContext,R.string.sensorAbsentR,Toast.LENGTH_SHORT).show()

        aSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        if(aSensor !=null)
            sm.registerListener(this,aSensor,SensorManager.SENSOR_DELAY_GAME)
        else Toast.makeText(applicationContext,R.string.sensorAbsentA,Toast.LENGTH_SHORT).show()
    }
    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.sensor.type == lSensor!!.type) s1 = "Освещённость: " + event.values[0]
        if (event!!.sensor.type == rSensor!!.type) s2 = "Проекция вектора по осям:\nOX(" + event.values[0] + ")\nOY(" + event.values[1] + ")\nOZ(" + event.values[2] + ")\n" +
                "скалярная мера угла поворота: " + event.values[3]
        if (event!!.sensor.type == aSensor!!.type) s3 = "Динамическое ускорение по осям:\nOX(" + event.values[0] + ")\nOY(" + event.values[1] + ")\nOZ(" + event.values[2] + ")"
        if(db.l.isChecked){
            dataSensor = s1
            db.sensText = dataSensor
        }else if(db.r.isChecked){
            dataSensor = s2
            db.sensText = dataSensor
        }else if(db.a.isChecked){
            dataSensor = s3
            db.sensText = dataSensor
        }
    }
    override fun onPause() {
        super.onPause()
        sm.unregisterListener(this)
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) { }
}