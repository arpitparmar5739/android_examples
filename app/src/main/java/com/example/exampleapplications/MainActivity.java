package com.example.exampleapplications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String titles[], description[];
    int imageResource[] = {R.drawable.cat, R.drawable.dog, R.drawable.cat, R.drawable.dog, R.drawable.cat, R.drawable.dog, R.drawable.cat, R.drawable.dog};
    MyOwnAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        titles = getResources().getStringArray(R.array.pet_name);
        description = getResources().getStringArray(R.array.desc);

        ad = new MyOwnAdapter(this, titles, description, imageResource);

        recyclerView.setAdapter(ad);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
