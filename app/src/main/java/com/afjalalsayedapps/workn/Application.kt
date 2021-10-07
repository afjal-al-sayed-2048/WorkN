package com.afjalalsayedapps.workn

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationManagerCompat
import com.afjalalsayedapps.workn.utils.CONSTS

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val sampleNotificationChannel = NotificationChannel(
                CONSTS.SAMPLE_NOTIFICATION_CHANNEL_ID,
                getString(R.string.sample_notification_channel_name),
                NotificationManager.IMPORTANCE_DEFAULT
            )
            sampleNotificationChannel.description = getString(R.string.sample_notification_channel_description)
            // val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val notificationManager = NotificationManagerCompat.from(applicationContext)
            notificationManager.createNotificationChannel(sampleNotificationChannel)
        }
    }
}