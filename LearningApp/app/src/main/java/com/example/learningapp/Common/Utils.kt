package com.example.learningapp.Common

import android.icu.util.Calendar
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.Format
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object{
        @RequiresApi(Build.VERSION_CODES.N)
        fun FormatDate(calendar: Calendar):String{
            val dateFormat = "dd/MM/yyyy"
            val simple = SimpleDateFormat(dateFormat, Locale.UK)
            return simple.format(calendar.time)
        }
    }
}