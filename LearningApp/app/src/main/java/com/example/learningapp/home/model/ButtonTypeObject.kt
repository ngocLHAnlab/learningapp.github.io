package com.example.learningapp.home.model

class ButtonTypeObject(var text:String, var type:TypeButton) {
}
enum class TypeButton{
    roomDB,
    design,
    login,
    recy,
    calculator,
    calculator_v2,
    news,
    datePicker,
    splass,
    notification
}