package com.example.exampleapplications;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000, 1000) {
            public void onTick(long millisecondsUntillDone) {
                Log.i("Seconds Left!", String.valueOf(millisecondsUntillDone/1000));
            }

            public void onFinish() {
                Log.i("We're done!", "No more countdown!");
            }
        }.start();

        /*
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Hey yo!", "5 seconds passed by");
                handler.postDelayed(this, 5000);
            }
        };

        handler.post(run);
        */
    }
}
