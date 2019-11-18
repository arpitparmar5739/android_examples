package com.example.exampleapplications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
//        return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.m1:
                Toast.makeText(this, "You touched Settings.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m2:
                Toast.makeText(this, "You touched  Mic.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m3:
                Toast.makeText(this, "You touched Edit.", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.text_view_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {
            case R.id.m1:
                Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                textView.setText(item.getTitle().toString());
                break;
            case R.id.m2:
            case R.id.m3:
                textView.setText(item.getTitle().toString());
                break;
        }

        return true;
    }
}
