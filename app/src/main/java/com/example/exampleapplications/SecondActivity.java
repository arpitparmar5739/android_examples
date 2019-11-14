package com.example.exampleapplications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private EditText editText;
    public final static String EXTRA_RETURN_MESSAGE = "com.example.exampleapplications.RETURN_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = (EditText) findViewById(R.id.editText);
    }

    public void submitTextToMainActivity(View view) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(EXTRA_RETURN_MESSAGE, editText.getText().toString());
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
