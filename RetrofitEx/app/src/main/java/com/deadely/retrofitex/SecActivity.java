package com.deadely.retrofitex;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecActivity extends Activity {
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        imageView = findViewById(R.id.iv_poster);
        textView = findViewById(R.id.tv_title);

    }
}