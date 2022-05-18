package com.example.pr410

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(){
    lateinit var sm: SensorManager
    lateinit var spinner: Spinner
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sm = getSystemService(SENSOR_SERVICE) as SensorManager
        spinner = findViewById(R.id.spinner)
        val sensors = resources.getStringArray(R.array.type_sensors)
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sensors)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                var s: String = ""
                val sensors1 = arrayOf(2,5,6,12,13)
                val sensors2 = arrayOf(1,4,8,9,10,11,15,16,17,18,19,30)
                val sensors3 = arrayOf(21,31,34)
                if (position == 0) {
                    for (i in sensors1) {
                        var g =  sm.getDefaultSensor(i);
                        if(g!= null) s+=g.name+"\n"
                    }
                }
                if (position == 1) {
                    for (i in sensors2) {
                        var g =  sm.getDefaultSensor(i);
                        if(g!= null) s+=g.name+"\n"
                    }
                }
                if (position == 2) {
                    for (i in sensors3) {
                        var g =  sm.getDefaultSensor(i);
                        if(g!= null) s+=g.name+"\n"
                    }
                }
                textView = findViewById(R.id.list_sensor);
                textView.setText(s)
            }
        }
    }
}