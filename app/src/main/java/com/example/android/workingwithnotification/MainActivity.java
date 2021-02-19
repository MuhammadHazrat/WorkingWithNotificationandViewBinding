package com.example.android.workingwithnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.android.workingwithnotification.databinding.ActivityMainBinding;

import static com.example.android.workingwithnotification.App.manager;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    private Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(this::showNotification);
    }

    private void showNotification(View view) {
        Log.e("tag", "function Entered");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = new Notification.Builder(getApplicationContext(), App.id1)
                    .setContentTitle("This is Content Title")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentText("This is Detail")
                    .build();
            manager.notify(1, notification);
        }

    }

}