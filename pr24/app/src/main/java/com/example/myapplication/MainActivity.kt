package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inspect = findViewById<Button>(R.id.inspect)
        val rezult = findViewById<TextView>(R.id.rezult)
        val mm: EditText = findViewById(R.id.mm)
        val sm: EditText = findViewById(R.id.sm)
        val dm: EditText = findViewById(R.id.dm)
        val m: EditText = findViewById(R.id.m)
        val km: EditText = findViewById(R.id.km)
        val answer = findViewById<ImageView>(R.id.answer)
        inspect.setOnClickListener({
            if ((mm.getText().toString().toDouble() == sm.getText().toString()
                    .toDouble() * 10) && (mm.getText().toString().toDouble() == dm.getText()
                    .toString().toDouble() * 100) && (mm.getText().toString()
                    .toDouble() == m.getText().toString().toDouble() * 1000) && (mm.getText()
                    .toString().toDouble() == km.getText().toString()
                    .toDouble() * 1000000) && (sm.getText().toString().toDouble() == dm.getText()
                    .toString().toDouble() * 10) && (sm.getText().toString()
                    .toDouble() == m.getText().toString().toDouble() * 100) && (sm.getText()
                    .toString().toDouble() == km.getText().toString()
                    .toDouble() * 100000) && (dm.getText().toString().toDouble() == m.getText()
                    .toString().toDouble() * 10) && (dm.getText().toString()
                    .toDouble() == km.getText().toString().toDouble() * 10000) && (m.getText()
                    .toString().toDouble() == km.getText().toString().toDouble() * 1000)
            ) {
                rezult.setText(R.string.good)
                rezult.setTextColor(Color.parseColor("#0000FF"))
                answer.setImageResource(R.drawable.cool)
            } else {
                rezult.setText(R.string.bad)
                rezult.setTextColor(Color.parseColor("#FF0000"))
                answer.setImageResource(R.drawable.bad)
            }
        })
        var i=1f
        answer.setOnTouchListener { view, motionEvent ->
            when (motionEvent.getAction()) {
                MotionEvent.ACTION_DOWN -> {answer.setAlpha(i-0.1f)
                if(i<0.2f){
                    i=1.1f
                }else{
                    i=i-0.1f
                }
                }
            }
            true
        }
    }
    }
