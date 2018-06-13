package com.tg.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView tv_receive;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv_receive = findViewById(R.id.tv_receive);
        Intent intent = getIntent();
        if (intent!=null){
            String message = intent.getStringExtra("message");
            tv_receive.setText(message);
        }

    }
}
