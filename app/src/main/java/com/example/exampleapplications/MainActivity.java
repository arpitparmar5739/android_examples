package com.example.exampleapplications;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView  = findViewById(R.id.myListView);
        ArrayList<String> myFamily = new ArrayList<>();

        myFamily.add("Arpit");
        myFamily.add("Aditya");
        myFamily.add("Ajay");
        myFamily.add("Sangita");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myFamily);
        myListView.setAdapter(arrayAdapter);
    }
}
