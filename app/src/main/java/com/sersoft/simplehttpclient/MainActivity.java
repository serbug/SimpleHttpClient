package com.sersoft.simplehttpclient;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> rssLinks = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRediff = findViewById(R.id.btnRediff);
        Button btnCinemaBlend = findViewById(R.id.btnCinemaBlend);
        btnRediff.setOnClickListener(this);
        btnCinemaBlend.setOnClickListener(this);
        rssLinks.add("https://www.techmeme.com/feed.xml");
        rssLinks.add("https://www.androidpolice.com/feed/");
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), RSSFeedActivity.class);
        switch (view.getId()) {
            case R.id.btnRediff:
                intent.putExtra("rssLink", rssLinks.get(0));
                startActivity(intent);
                break;
            case R.id.btnCinemaBlend:
                intent.putExtra("rssLink", rssLinks.get(1));
                startActivity(intent);
                break;
        }
    }
}