package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a = findViewById<EditText>(R.id.sideA)
        val b = findViewById<EditText>(R.id.sideB)
        val c = findViewById<EditText>(R.id.sideC)
        val bt = findViewById<Button>(R.id.getSolution)
        val tv = findViewById<TextView>(R.id.solution)
        val sp = findViewById<Spinner>(R.id.spinner)
        val l = resources.getStringArray(R.array.lang)
        if (sp != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, l)
            sp.adapter = adapter

            sp.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    if(l[position]=="Сумма длин рёбер"){
                        bt.setOnClickListener({
                            var a: Int? = a.text.toString().toIntOrNull()
                            var b: Int? = b.text.toString().toIntOrNull()
                            var c: Int? = c.text.toString().toIntOrNull()
                            if(a!=null&&b!=null&&c!=null) {
                                tv.setText("Ответ:"+4*(a!!.toInt()+b!!.toInt()+c!!.toInt()))
                            }else
                                tv.setText("Ошибка ввода")
                        })
                    }
                    if(l[position]=="Площадъ поверхности"){
                        bt.setOnClickListener({
                            var a: Int? = a.text.toString().toIntOrNull()
                            var b: Int? = b.text.toString().toIntOrNull()
                            var c: Int? = c.text.toString().toIntOrNull()
                            if(a!=null&&b!=null&&c!=null) {
                                tv.setText("Ответ:"+(2*((a!!.toInt()*b!!.toInt())+(b!!.toInt()*c!!.toInt())+(a!!.toInt()*c!!.toInt()))))
                            }else
                                tv.setText("Ошибка ввода")
                        })
                    }
                    if(l[position]=="Объем"){
                        bt.setOnClickListener({
                            var a: Int? = a.text.toString().toIntOrNull()
                            var b: Int? = b.text.toString().toIntOrNull()
                            var c: Int? = c.text.toString().toIntOrNull()
                            if(a!=null&&b!=null&&c!=null) {
                                tv.setText("Ответ:" + a!!.toInt()*b!!.toInt()*c!!.toInt())
                            }else
                                tv.setText("Ошибка ввода")
                        })
                    }
                }
            }
        }
    }
}