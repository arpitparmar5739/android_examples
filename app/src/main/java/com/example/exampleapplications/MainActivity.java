package com.example.exampleapplications;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView timesTableView;
    ArrayAdapter<Integer> arrayAdapter;

    public void updateTimesTableView(ArrayList<Integer> times) {
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, times);
        timesTableView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Integer> times = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(19);

        timesTableView = findViewById(R.id.timesTableView);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, times);
        timesTableView.setAdapter(arrayAdapter);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                for(int i=0; i<times.size(); i++){
                    times.set(i, (i+1)*(progress+1));
                }
                updateTimesTableView(times);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
