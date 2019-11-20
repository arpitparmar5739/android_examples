package com.example.exampleapplications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Please charge nahi to band ho jayega!", Toast.LENGTH_SHORT).show();
    }
}
