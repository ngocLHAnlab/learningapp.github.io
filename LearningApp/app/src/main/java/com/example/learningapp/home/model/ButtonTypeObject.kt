package com.example.learningapp.home.model

class ButtonTypeObject(var text:String, var type:TypeButton) {
}
enum class TypeButton{
    design,
    login,
    recy,
    calculator,
    datePicker,
    splass,
    notification
}