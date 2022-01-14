package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    var q="OFF"
    var w="OFF"
    var e=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed = findViewById<EditText>(R.id.editText)
        val ch = findViewById<CheckBox>(R.id.checkBox)
        val r1 = findViewById<RadioButton>(R.id.radioButton)
        val r2 = findViewById<RadioButton>(R.id.radioButton2)
        val tb = findViewById<ToggleButton>(R.id.toggleButton)
        val bt = findViewById<Button>(R.id.button)
        val tv = findViewById<TextView>(R.id.textView)
        ch?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) q="ON" else q="OFF"
        }
        tb.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) w="ON" else w="OFF"
        }

        r1.setOnClickListener(View.OnClickListener {
            e = "\nRadioGroup: RadioButton 1"
        })

        r2.setOnClickListener(View.OnClickListener {
            e = "\nRadioGroup: RadioButton 2"
        })
        bt.setOnClickListener({
            tv.setText("EditText:"+ed.getText().toString()+"\nCheckBox: "+q+"\nToggleButton: "+w+e)
        })
    }
    fun RadioButtonClick(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.radioButton ->
                    if (checked) {
                        e = "\nRadioGroup: RadioButton 1"
                    }
                R.id.radioButton2 ->
                    if (checked) {
                        e = "\nRadioGroup: RadioButton 2"
                    }
            }
        }
    }
}