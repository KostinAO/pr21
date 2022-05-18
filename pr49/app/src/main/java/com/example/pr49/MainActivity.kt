package com.example.pr49

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.work.*

class MainActivity : AppCompatActivity() {
    var count:Int = 0
    val data = Data.Builder()
        .putInt("click", count)
        .build()
    val process1 = OneTimeWorkRequestBuilder<TextWorker>().build()
    val process2 = OneTimeWorkRequestBuilder<LongWorker>().build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.clicker).setOnClickListener {
            count+=1
            findViewById<Button>(R.id.clicker).setText(count.toString())
        }
        findViewById<Button>(R.id.startprocess).setOnClickListener {
            WorkManager.getInstance(this)
                .beginWith(process1)
                .then(process2)
                .enqueue()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        WorkManager.getInstance(this).cancelAllWork()
    }
}

class TextWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams)  {
    override fun doWork(): Result {
        Log.d("test_worker","text_worker_start")
        val c:String = "friend"
        val d = Data.Builder()
            .build()
        for (l in 'a'..'z'){
            for (j in 'a'..'z'){
                for (k in 'a'..'z'){
                    for (p in 'a'..'z'){
                        for (t in 'a'..'z'){
                            for (m in 'a'..'z'){
                                var s:String = ""+l+j+k+p+t+m
                                if (s == c) {
                                    val d = workDataOf("data_is" to s)
                                    return Result.success(d)
                                }
                            }
                        }
                    }
                }
            }
        }
        Log.d("test_worker","text_worker_stop")
        return Result.success()
    }
}

class LongWorker(appContext: Context, params: WorkerParameters) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        Log.d("test_worker","long_worker_start")
        val data1 = inputData.getString("data_is")
        if (data1 == null) {
            val data1 = workDataOf("data_is" to "none")
        }
        val data2 = inputData.getInt("click", 100)
        var p:Long = 0
        if (data1 != null) {
            for (i in 1..data1.length*10000) {
                for (j in 1..data2) {
                    p += i.mod(j)
                }
            }
        }
        Log.d("test_worker","long_worker_stop with rezult $p")
        return Result.success()
    }
}