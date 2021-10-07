package com.afjalalsayedapps.workn.presentation

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.afjalalsayedapps.workn.R
import com.afjalalsayedapps.workn.presentation.ui.theme.WorkNTheme
import com.afjalalsayedapps.workn.utils.CONSTS

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkNTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BaseContent(
                        pushNotification = {
                            pushSampleNotification()
                        }
                    )
                }
            }
        }
    }

    fun pushSampleNotification(){
        val builder = NotificationCompat.Builder(applicationContext, CONSTS.SAMPLE_NOTIFICATION_CHANNEL_ID)
        val bigPictureBitmap = BitmapFactory.decodeResource(resources, R.drawable.sample_notification_banner)
        builder.apply {
            setContentTitle("Big banner")
            setContentText("expand ot view the banner")
            setSmallIcon(R.drawable.ic_android)
            setStyle(NotificationCompat.BigPictureStyle().bigPicture(bigPictureBitmap))
        }
        val notificaiton = builder.build()
        val notificationManager = NotificationManagerCompat.from(applicationContext)
        notificationManager.notify(CONSTS.SAMPLE_NOTIFICATION_ID, notificaiton)
    }
}

@Composable
fun BaseContent(
    pushNotification: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { pushNotification() }
        ) {
            Text(
                text = "PUSH"
            )
        }
    }
}
