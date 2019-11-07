package com.example.exampleapplications;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView minutesTextView, secondsTextView;
    Integer timeLeft=0;
    CountDownTimer timer;

    public void updateTime(int timeLeft) {
        this.timeLeft = timeLeft;
        this.setTimeTextViews();
        this.seekBar.setProgress(timeLeft);
    }

    public void setTimeTextViews() {
        this.minutesTextView.setText(String.format("%02d", timeLeft / 60));
        this.secondsTextView.setText(String.format("%02d", timeLeft % 60));
    }

    public void goClicked(View view) {
        if (timer != null)
            timer.cancel();

        timer = new CountDownTimer(timeLeft.longValue()*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (timeLeft > 0)
                    updateTime(timeLeft-1);
            }

            @Override
            public void onFinish() {
                MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(), R.raw.air_horn);
                mplayer.start();
            }
        };
        timer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        minutesTextView = (TextView) findViewById(R.id.minutesTextView);
        secondsTextView = (TextView) findViewById(R.id.secondsTextView);

        seekBar.setMax(180);

        this.setTimeTextViews();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTime(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (timer != null)
                    timer.cancel();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
