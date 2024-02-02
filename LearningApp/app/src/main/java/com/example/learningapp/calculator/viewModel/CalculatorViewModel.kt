package com.example.learningapp.calculator.viewModel

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.example.learningapp.Common.Common

class CalculatorViewModel:BaseObservable() {
    companion object{
        val ADD = '+'
        val SUBTRACT = '-'
        val MULTIPLY = '*'
        val DIVISION = '/'
        val PERCENT = '%'
        val NONE = '0'
    }
    var currentSymbol = NONE
    var input = MutableLiveData("0")
    var output = MutableLiveData("0")
    var firstValue:Double = 0.0
    var secondValue:Double = 0.0
    fun numberButtonClick(num: Int){
        input.value+=num
//        if (input.value!!.toDouble() == 0.0){
//            input.value = num.toDouble().toString()
//        }else{
//            input.value+=num
//            val n:Double = input.value!!.toDouble()
//            input.value = n.toString()
//        }
        Log.d(Common.TAG, "input: $input, firstValue: $firstValue")
    }
    fun dotButtonClick(){
        input.value+="."
//        if (!input.value!!.contains('.')){
//            input.value+="."
//            val n:Double = input.value!!.toDouble()
//            input.value = n.toString()
//        }
        Log.d(Common.TAG, "input: $input, firstValue: $firstValue")
    }
    fun clearButtonClick(){
        if (input.value!!.length > 1){
            input.value = input.value!!.substring(0, input.value!!.length-1)
        }else{
            firstValue = 0.0
            secondValue = 0.0
            input.value = "0"
            output.value = "0"
        }
        Log.d(Common.TAG, "input: $input, firstValue: $firstValue")
    }
    fun offButtonClick(){
        firstValue = 0.0
        secondValue = 0.0
        input.value = "0"
        output.value = "0"
        Log.d(Common.TAG, "input: $input, firstValue: $firstValue")
    }
    fun equalButtonClick(){
        calculations()
        output.value = firstValue.toString()
        firstValue = 0.0
        currentSymbol = NONE
        Log.d(Common.TAG, "input: $input, firstValue: $firstValue")
    }
    fun buttonAddClick(){
        calculations()
        currentSymbol = ADD
        output.value = firstValue.toString()+ ADD
        input.value = "0"
        Log.d(Common.TAG, "input: $input, output: $output")
    }
    fun buttonSUBTRACTClick(){
        calculations()
        currentSymbol = SUBTRACT
        output.value = firstValue.toString()+ SUBTRACT
        input.value = "0"
        Log.d(Common.TAG, "input: $input, output: $output")
    }
    fun buttonMULTIPLYClick(){
        calculations()
        currentSymbol = MULTIPLY
        output.value = firstValue.toString()+ MULTIPLY
        input.value = "0"
        Log.d(Common.TAG, "input: $input, output: $output")
    }
    fun buttonDIVISIONClick(){
        calculations()
        currentSymbol = DIVISION
        output.value = firstValue.toString()+ DIVISION
        input.value = "0"
        Log.d(Common.TAG, "input: $input, output: $output")
    }
    fun buttonPERCENTClick(){
        calculations()
        currentSymbol = PERCENT
        output.value = firstValue.toString()+ PERCENT
        input.value = "0"
        Log.d(Common.TAG, "input: $input, output: $output")
    }
    fun calculations(){
        Log.d(Common.TAG, "firstValue: $firstValue")
        if (firstValue != 0.0){
            Log.d(Common.TAG, "firstValue != Double.NaN")
            secondValue = input.value!!.toDouble()
            input.value = "0"
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
            Log.d(Common.TAG, "firstValue == Double.NaN")
            firstValue = input.value!!.toDouble()
        }
        Log.d(Common.TAG, "firstValue: $firstValue, secondValue: $secondValue")
    }
}