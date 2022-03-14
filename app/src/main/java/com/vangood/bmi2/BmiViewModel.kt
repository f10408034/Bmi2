package com.vangood.bmi2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiViewModel :ViewModel() {
    //ViewModel
    val bmi = MutableLiveData<Float>()

    fun set (weight: Float, height: Float) {
        val _bmi = weight/(height*height)
        bmi.value = _bmi
    }
}