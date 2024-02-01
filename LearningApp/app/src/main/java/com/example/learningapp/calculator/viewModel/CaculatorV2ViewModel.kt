package com.example.learningapp.calculator.viewModel

import androidx.lifecycle.ViewModel
import com.example.learningapp.calculator.model.Calculator

class CaculatorV2ViewModel:ViewModel() {
    fun calculator(num1:Int, num2:Int):Calculator{
        val sum = num1+num2
        return Calculator(num1, num2, sum)
    }
}