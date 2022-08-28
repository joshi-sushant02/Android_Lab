package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.androids_list);
        Button back= findViewById(R.id.android_back);
        back.setOnClickListener(backbuttonListener);

    }
    View.OnClickListener backbuttonListener= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent backToHomePage= new Intent(lists.this,MainActivity.class);
            startActivity(backToHomePage);
        }
    };
}