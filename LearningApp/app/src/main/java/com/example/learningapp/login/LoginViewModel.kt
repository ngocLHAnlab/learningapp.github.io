package com.example.learningapp.login

import android.util.Log
import androidx.databinding.BaseObservable
import com.example.learningapp.Common.Common

class LoginViewModel : BaseObservable() {
    var email = ""
    var pass = ""
    fun login(){
        Log.d(Common.TAG, "email: $email, pass: $pass")
    }
}