package com.example.exampleapplications;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    EditText editText;

    public class ImageDownloader extends AsyncTask<URL, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(URL... urls) {
            try {
                URL url = urls[0];
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream in = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(in);
                return myBitmap;
            } catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }

    public void downloadImage(View view) {
        ImageDownloader task = new ImageDownloader();
        Bitmap myImage;

        try {
            URL url = new URL(String.valueOf(editText.getText()));
            myImage = task.execute(url).get();
            imageView.setImageBitmap(myImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editUrl);
    }
}
