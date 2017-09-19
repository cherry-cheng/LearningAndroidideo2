package com.example.chengyonghui.xmlexample.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by chengyonghui on 2017/9/19.
 */
public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("onreceiver create");
        //得到短信消息里面的内容
        Bundle bundle = intent.getExtras();
        Object[] myOBJpdus = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[myOBJpdus.length];
        System.out.println(messages.length);
        for (int i = 0; i<myOBJpdus.length; i++) {
            messages[i] = SmsMessage.createFromPdu((byte[]) myOBJpdus[i]);
            System.out.println(messages[i].getDisplayMessageBody());
        }
    }
}
