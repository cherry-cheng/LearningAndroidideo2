package com.example.chengyonghui.xmlexample.broadcast;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.chengyonghui.xmlexample.R;

/**
 * Created by chengyonghui on 2017/9/19.
 */
public class BroadCastTestActivtiy extends AppCompatActivity {

    private Button registerbt = null;
    private Button unregisterbt = null;
    private SMSReceiver smsReceiver = null;
    public static final String SMS_ACTION = "android.provider.Telephony.SMS_RECEIVER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_layout);
        registerbt = (Button)findViewById(R.id.registerbc);
        unregisterbt = (Button)findViewById(R.id.unregisterbc);
        registerbt.setOnClickListener(new RegisterReceiverListener());
        unregisterbt.setOnClickListener(new UnRegisterReceiverListener());
    }

    class RegisterReceiverListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            smsReceiver = new SMSReceiver();
            IntentFilter filter = new IntentFilter();
            filter.addAction(SMS_ACTION);
            //注册广播
            BroadCastTestActivtiy.this.registerReceiver(smsReceiver, filter);
        }
    }

    class UnRegisterReceiverListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //注销广播
            if (smsReceiver != null){
                BroadCastTestActivtiy.this.unregisterReceiver(smsReceiver);
            }
        }
    }
}
