package com.vangood.bmi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.vangood.bmi2.databinding.ActivityTransactionBinding
import com.vangood.bmi2.databinding.RowTransactionBinding
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL
import kotlin.concurrent.thread
import com.google.gson.reflect.TypeToken as TypeToken

class TransactionActivity : AppCompatActivity() {
    lateinit var binding: ActivityTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.hasFixedSize()
        binding.recycler.layoutManager = LinearLayoutManager(this)
        thread {
            val json = URL("https://atm201605.appspot.com/h").readText()
            val gson = Gson()
            val transactions = gson.fromJson(json, Array<Transaction>::class.java).toList()
            transactions.forEach {
                println(it)
            }
            runOnUiThread {
                binding.recycler.adapter = object : RecyclerView.Adapter<TranViewHolder>() {
                    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TranViewHolder {
                        val binding = RowTransactionBinding.inflate(layoutInflater, parent, false)
                        return TranViewHolder(binding)
                    }

                    override fun onBindViewHolder(holder: TranViewHolder, position: Int) {
                        val tran = transactions.get(position)
                        holder.amount.setText(tran.amount.toString())
                        holder.date.setText(tran.date)
                        holder.type.setText(tran.type.toString())
                    }

                    override fun getItemCount(): Int {
                        return transactions.size
                    }

                }
            }


        }
    }

    inner class TranViewHolder(val binding: RowTransactionBinding):
        RecyclerView.ViewHolder(binding.root) {
        val amount = binding.tranAmount
        val date = binding.tranDate
        val type = binding.tranType
    }
}
data class Transaction(val account: String, val date: String, val amount:Int, val type:Int) {

}