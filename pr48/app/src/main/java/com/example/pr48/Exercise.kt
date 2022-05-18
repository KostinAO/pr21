package com.example.pr48

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Exercise : AppCompatActivity() {
    var num: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        var pictures = arrayOf<Int>(
            R.drawable.kulis,
            R.drawable.moth,
            R.drawable.artist,
            R.drawable.curtain,
            R.drawable.shooter,
            R.drawable.viy
        )
        var exText = getResources().getStringArray(R.array.exercises)
        num = Random.nextInt (0, 5)
        findViewById<ImageView>(R.id.pict).setImageResource(pictures[num])
        findViewById<TextView>(R.id.exercText).setText(exText[num])
        findViewById<Button>(R.id.ok).setOnClickListener {
            finish()
        }
    }
}