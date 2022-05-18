package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.widget.Toast

class Студент1 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        var resCode = resultCode
        var res = getResultExtras(true)
        var str = res.getString("strEx")
        str += " \nСтудент1"
        res.putString("strEx",str)
        setResult(++resCode, resultData, res)
    }
}
class Студент2 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        var resCode = resultCode
        var res = getResultExtras(true)
        var str = res.getString("strEx")
        str += " \nСтудент2"
        res.putString("strEx",str)
        setResult(++resCode, resultData, res)
    }
}
class Студент3 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        var resCode = resultCode
        var res = getResultExtras(true)
        var str = res.getString("strEx")
        str += " \nСтудент3"
        res.putString("strEx",str)
        setResult(++resCode, resultData, res)
    }
}
class Студент4 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        var resCode = resultCode
        var res = getResultExtras(true)
        var str = res.getString("strEx")
        str += " \nСтудент4"
        res.putString("strEx",str)
        setResult(++resCode, resultData, res)
    }
}
class Студент5 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        var resCode = resultCode
        var res = getResultExtras(true)
        var str = res.getString("strEx")
        str += " \nСтудент5"
        res.putString("strEx",str)
        setResult(++resCode, resultData, res)
    }
}
class Студент6 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        var resCode = resultCode
        var res = getResultExtras(true)
        var str = res.getString("strEx")
        str += " \nСтудент6"
        res.putString("strEx",str)
        setResult(++resCode, resultData, res)
    }
}