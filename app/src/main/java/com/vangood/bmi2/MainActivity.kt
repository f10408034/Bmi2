package com.vangood.bmi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.vangood.bmi2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val check = Check()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun bmi(view: View){
        var weight = binding.edWeight.text.toString().toFloat()
        var height = binding.edHeight.text.toString().toFloat()
        binding.tvResult.text = ("Your Bmi : ${weight/(height*height)} , ${check.checkRange(weight/(height*height))}")

    }
}