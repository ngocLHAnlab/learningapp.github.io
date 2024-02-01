package com.example.learningapp.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapp.home.model.ButtonTypeObject
import com.example.learningapp.home.model.TypeButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel : ViewModel() {
    var buttonTypeObjects = MutableLiveData<List<ButtonTypeObject>>()
    init {
        CoroutineScope(Dispatchers.Main).launch {
            val productList = ArrayList<ButtonTypeObject>()
            productList.add(ButtonTypeObject("News", TypeButton.news))
            productList.add(ButtonTypeObject("Design", TypeButton.design))
            productList.add(ButtonTypeObject("Login", TypeButton.login))
            productList.add(ButtonTypeObject("RecyclerView", TypeButton.recy))
            productList.add(ButtonTypeObject("Calculator", TypeButton.calculator))
            productList.add(ButtonTypeObject("Calculator_V2", TypeButton.calculator_v2))
            productList.add(ButtonTypeObject("DatePicker", TypeButton.datePicker))
            productList.add(ButtonTypeObject("splass", TypeButton.splass))
            productList.add(ButtonTypeObject("notification", TypeButton.notification))
            buttonTypeObjects.value = productList
        }
    }
}