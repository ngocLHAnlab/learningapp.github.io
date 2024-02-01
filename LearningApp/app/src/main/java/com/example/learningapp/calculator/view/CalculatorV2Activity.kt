package com.example.learningapp.calculator.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.learningapp.R
import com.example.learningapp.calculator.viewModel.CaculatorV2ViewModel
import com.example.learningapp.databinding.ActivityCalculatorV2Binding

class CalculatorV2Activity : AppCompatActivity() {
    lateinit var binding: ActivityCalculatorV2Binding
    lateinit var viewModel:CaculatorV2ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calculator_v2)
        viewModel = ViewModelProvider(this).get(CaculatorV2ViewModel::class.java)
    }
    fun btnEqualClick(view:View){
        val num1 = binding.edtNum1.text.toString().toInt()
        val num2 = binding.edtNum2.text.toString().toInt()
        val calculator = viewModel.calculator(num1, num2)
        val sum = calculator.sum
        binding.txtSum.setText(sum.toString())
    }
}