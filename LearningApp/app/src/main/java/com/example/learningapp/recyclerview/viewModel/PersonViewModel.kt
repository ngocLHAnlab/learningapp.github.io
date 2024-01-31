package com.example.learningapp.recyclerview.viewModel

import android.content.Context
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.example.learningapp.recyclerview.model.PersonObject

class PersonViewModel(var context: Context) : BaseObservable() {
    var personObjectsData = ArrayList<PersonObject>()
    var personObjects = MutableLiveData<List<PersonObject>>()
    var searchText=MutableLiveData("")
    var name:String = ""
    var personObject:PersonObject = PersonObject(true, "")
    var isMan = MutableLiveData(true)
    init {
        val list = ArrayList<PersonObject>()
        list.add(PersonObject(true, "Ngoc"))
        list.add(PersonObject(false, "Nhoc"))
        list.add(PersonObject(true, "Mop"))
        personObjects.value = list
        personObjectsData = list
    }
    fun avatarClick() {
        isMan.value = !isMan.value!!
    }
    fun buttonAddClick() {
        val p = PersonObject(isMan.value!!, name)
        val list= ArrayList<PersonObject>()
        personObjects.value?.let { list.addAll(it) }
        list.add(p)
        personObjects.value = list
        personObjectsData.add(p)
    }

}