package com.example.popit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun moodChange(view: View) {
        val i = findViewById<ImageView>(R.id.mood)
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.good ->
                    if (checked) {
                        i.setImageResource(R.drawable.cheerful)
                    }
                R.id.bad ->
                    if (checked) {
                        i.setImageResource(R.drawable.cry)
                    }
            }
        }
    }
    fun OnClick(view: View){
        val t1 = findViewById<EditText>(R.id.vevent).getText().toString()
        val t2 = findViewById<EditText>(R.id.vdate).getText().toString()
        val t3 = findViewById<EditText>(R.id.vtime).getText().toString()
        val t4 = findViewById<EditText>(R.id.post).getText().toString()
        Toast.makeText(applicationContext, "Записано!"+"\nСобытие: "+t1+"\nДата: "+t2+"\nВремя: "+t3+"\nЗаметки: "+t4,Toast.LENGTH_LONG).show()
        findViewById<EditText>(R.id.vevent).getText().clear()
        findViewById<EditText>(R.id.vdate).getText().clear()
        findViewById<EditText>(R.id.vtime).getText().clear()
        findViewById<EditText>(R.id.post).getText().clear()
    }
}