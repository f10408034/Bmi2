package com.vangood.bmi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.vangood.bmi2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val check = Check()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bHelp.setOnClickListener {
            Log.d("MainActivity", "OnClick Help")
        }
    }

    fun bmi(view: View){
        Log.d("MainActivity","clicked")
        var weight = binding.edWeight.text.toString().toFloat()
        var height = binding.edHeight.text.toString().toFloat()
        var bmi = weight/(height*height)

        var state = check.checkRange(bmi)

        val message = when(state) {
            Check.checkState.UNDER -> getString(R.string.under)
            Check.checkState.NORMAL -> getString(R.string.normal)
            else -> getString(R.string.over)
        }
        Toast.makeText(this, "Your BMI$bmi", Toast.LENGTH_LONG).show()
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("Hello")
//        builder.setMessage("Your BMI is $bmi")
//        builder.setPositiveButton("OK", null)
//        val dialog = builder.create()
//        dialog.show()
        AlertDialog.Builder(this)
            .setTitle("Hello")
            .setMessage("Your BMI is $bmi")
            .setPositiveButton("OK",null)
//            .show()
        binding.tvResult.text = ("Your Bmi : ${bmi} , $message")
    }
}