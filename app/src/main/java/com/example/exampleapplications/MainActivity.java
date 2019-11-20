package com.example.exampleapplications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showNotification(View view) {
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(this.NOTIFICATION_SERVICE);

        int notificationId = 1;
        String channelId = "channel-01";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelName = "Great Channel";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("1 New Message")
                .setContentText("Hi, Your notification works now.");

        Intent i1 = new Intent(this, MainActivity.class);
        PendingIntent pd = PendingIntent.getActivity(this, 1, i1, 0);
        mBuilder.setContentIntent(pd);

        notificationManager.notify(notificationId, mBuilder.build());
        finish();
    }
}
