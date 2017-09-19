package com.example.chengyonghui.xmlexample.wifi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.chengyonghui.xmlexample.R;

/**
 * Created by chengyonghui on 2017/9/19.
 */
public class WifiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifi_layout);
        //主要是wifimanager这个类对wifi的状态进行管理
    }
}
