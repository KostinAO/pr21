package ru.samsung.itacademy.mdev.getusdrate

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

class RateCheckInteractor {
    val networkClient = NetworkClient()

    suspend fun requestRate(): String {
        try {
            val jsonString = networkClient.request("https://www.freeforexapi.com/api/live?pairs=USDRUB")
            return parseRate(jsonString!!)
        } catch (e: Exception) {
            Log.e("RateCheckInteractor", "", e)
        }
        return ""
    }

    private fun parseRate(jsonString: String): String {
        try {
            return JSONObject(jsonString)
                .getJSONObject("rates")
                .getJSONObject("USDRUB")
                .getString("rate")
        } catch (e: Exception) {
            Log.e("RateCheckInteractor", "", e)
        }
        return ""
    }
}