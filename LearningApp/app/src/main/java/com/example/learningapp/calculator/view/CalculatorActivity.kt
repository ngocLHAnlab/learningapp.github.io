package com.example.learningapp.calculator.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.learningapp.R
import com.example.learningapp.calculator.viewModel.CalculatorViewModel
import com.example.learningapp.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    lateinit var binding: ActivityCalculatorBinding
    lateinit var viewModel:CalculatorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calculator)
        viewModel = CalculatorViewModel()
        binding.viewModel = viewModel
        viewModel.input.observe(this){
            binding.txtInput.setText(it)
        }
        viewModel.output.observe(this){
            binding.txtOutput.setText(it)
        }
    }
}