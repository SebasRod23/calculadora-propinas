package com.example.calculadoradepropinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.calculadoradepropinas.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initUI()
        setContentView(binding.getRoot())
    }

    private fun initUI(){
        binding.button15.setOnClickListener {
            interfaceCalculateTips(0.15)
        }
        binding.button25.setOnClickListener {
            interfaceCalculateTips(0.25)
        }
        binding.button35.setOnClickListener {
            interfaceCalculateTips(0.35)
        }
        binding.roundButton.setOnClickListener{
            roundResult()
        }
    }

    private fun interfaceCalculateTips(percentage: Double){
        val amount = binding.editTextNumberDecimal.text.toString()
        val amountValue = amount.toDoubleOrNull()
        if(amountValue == null || amountValue<=0){
            binding.totalTip.text = "0.0"
            binding.totalAmount.text = "0.0"
            Toast.makeText(this, "Input value not valid", Toast.LENGTH_SHORT).show()
            return
        }
        binding.totalTip.text = "${amountValue * percentage}"
        binding.totalAmount.text = "${amountValue * (1+percentage)}"
        Toast.makeText(this, "Total amount is: ${amountValue * (1+percentage)}", Toast.LENGTH_SHORT).show()
    }

    private fun roundResult(){
        val tip = binding.totalTip.text.toString().toDouble()
        val total = binding.totalAmount.text.toString().toDouble()

        binding.totalTip.text = "${tip.roundToInt()}"
        binding.totalAmount.text = "${total.roundToInt()}"
    }
}