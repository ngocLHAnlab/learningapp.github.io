package com.example.learningapp.calculator.viewModel

import android.util.Log
import androidx.databinding.BaseObservable
import com.example.learningapp.Common.Common
import java.text.DecimalFormat

class CalculatorViewModel:BaseObservable() {
    companion object{
        val ADD = '+'
        val SUBTRACT = '-'
        val MULTIPLY = '*'
        val DIVISION = '/'
        val PERCENT = '%'
        val NONE = ' '
    }
    var currentSymbol = NONE
    var input = ""
    var output = ""
    var firstValue = Double.NaN
    var secondValue = Double.NaN
    lateinit var decimalFormat:DecimalFormat
    fun numberButtonClick(num: Int){
        Log.d(Common.TAG, "num: $num")
        input+=num
        Log.d(Common.TAG, "input: $input")
    }
    fun buttonAddClick(){
        calculations()
        currentSymbol = ADD
        output = firstValue.toString()+ ADD
        input = ""
        Log.d(Common.TAG, "input: $input, output: $output")
    }
    fun calculations(){
        if (firstValue != Double.NaN){
            secondValue = input.toDouble()
            input = ""
            if (currentSymbol == ADD){
                firstValue = this.firstValue+secondValue
            }else if (currentSymbol == SUBTRACT){
                firstValue = this.firstValue-secondValue
            }else if (currentSymbol == MULTIPLY){
                firstValue = this.firstValue*secondValue
            }else if (currentSymbol == DIVISION){
                firstValue = this.firstValue/secondValue
            }else if (currentSymbol == PERCENT){
                firstValue = this.firstValue%secondValue
            }
        }else{
            firstValue = input.toDouble()
        }
        Log.d(Common.TAG, "firstValue: $firstValue, secondValue: $secondValue")
    }
}