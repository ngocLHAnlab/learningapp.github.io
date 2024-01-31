package com.example.learningapp.design

import android.app.DatePickerDialog
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.Color
import android.icu.util.Calendar
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapp.Common.Common
import com.example.learningapp.Common.Utils
import com.example.learningapp.R
import com.example.learningapp.home.view.MainActivity

@RequiresApi(Build.VERSION_CODES.N)
class DesignViewModel(var context: Context): ViewModel() {
    var calendar: Calendar = Calendar.getInstance()
    var dateString = MutableLiveData("dd/MM/YYYY")
    init {
        dateString.value = Utils.FormatDate(calendar)
    }
    fun dateButtonClick(){
        DatePickerDialog(context, { datePicker, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            Log.d(Common.TAG, Utils.FormatDate(calendar))
            dateString.value = Utils.FormatDate(calendar)
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun notifyButtonClick(){
        val CHANNEL_ID = "channelId"
        val CHANNEL_NAME = "channelName"
        val NOTIFY_ID = 0

        val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
            lightColor = Color.BLUE
            enableLights(true)
        }
        val notificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("Ngoc is coming...")
            .setContentText("dfgdsfghftkdng sdgkdlskjg sdjg")
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()
        val notificationManagerCompat = NotificationManagerCompat.from(context)
        notificationManagerCompat.notify(NOTIFY_ID, notification)
    }
}