package ru.samsung.itacademy.mdev

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RandomViewModel : ViewModel() {
    val counter = MutableLiveData<Int>()
    // Can also be written as:
    // val counter: LiveData<Int> = MutableLiveData<Int>()

    fun onIncrementClicked() {
        counter.value = (0..50).random()
    }
}