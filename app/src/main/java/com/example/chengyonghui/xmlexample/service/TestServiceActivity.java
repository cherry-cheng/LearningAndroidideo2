package com.example.chengyonghui.xmlexample.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.chengyonghui.xmlexample.R;

/**
 * Created by chengyonghui on 2017/9/19.
 */
public class TestServiceActivity extends AppCompatActivity {
    private Button startService = null;
    private Button stopService = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_layout);
        startService = (Button)findViewById(R.id.startService);
        startService.setOnClickListener(new StartServiceListener());
        stopService = (Button)findViewById(R.id.stopService);
        stopService.setOnClickListener(new StopServiceListener());
        System.out.println("Activity onCreate");
    }

    class StartServiceListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(TestServiceActivity.this, FirstService.class);
            startService(intent);
        }
    }

    class StopServiceListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(TestServiceActivity.this, FirstService.class);
            stopService(intent);
        }
    }
}
