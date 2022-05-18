package ru.samsung.itacademy.mdev.getusdrate

import android.location.Location
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {
    val usdRate = MutableLiveData<String>()
    val rateCheckInteractor = RateCheckInteractor()

    fun onCreate() {
        refreshRate()
    }

    fun onRefreshClicked() {
        refreshRate()
    }

    private fun refreshRate() {
        val job: Job = GlobalScope.launch(Dispatchers.IO) {
            usdRate.postValue(rateCheckInteractor.requestRate())
        }
    }

    companion object {
        const val TAG = "MainViewModel"
        const val USD_RATE_URL = "https://www.freeforexapi.com/api/live?pairs=USDRUB"
    }
}