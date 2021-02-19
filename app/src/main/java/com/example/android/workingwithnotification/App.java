package com.example.android.workingwithnotification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String id1 = "id1";
    public static final String id2  = "id2";
    public static NotificationManager manager;

    @Override
    public void onCreate() {
        super.onCreate();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel1 = new NotificationChannel(id1, "channel1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("This is Description");

            NotificationChannel channel2 = new NotificationChannel(id2, "Channel 2", NotificationManager.IMPORTANCE_DEFAULT);

            manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }

    }
}
