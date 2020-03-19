package com.example.listview_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Introduce extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        Intent intent = getIntent();
        ImageView imageView = findViewById(R.id.photo);
        TextView textView = findViewById(R.id.txt_intro);
        imageView.setImageResource(intent.getIntExtra("imageID",R.mipmap.emoji_kids01));
        textView.setText(intent.getStringExtra("studentName"));
    }
}
