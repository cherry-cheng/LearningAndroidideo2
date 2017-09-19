package com.example.chengyonghui.xmlexample.socket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.chengyonghui.xmlexample.R;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by chengyonghui on 2017/9/19.
 */
public class SocketActivity extends AppCompatActivity {
    private Button startButton = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socket_servert_layout);
        startButton = (Button)findViewById(R.id.socketBt);
        startButton.setOnClickListener(new StartSocketListener());
    }

    class StartSocketListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            new ServerThread().start();
        }
    }

    class ServerThread extends Thread {
/*        //TCP协议
        public void run() {
            //声明一个ServerSocket对象
            ServerSocket serverSocket = null;
            try {
                //创建一个ServerSocket对象，并让这个Socket在4567端口监听
                serverSocket = new ServerSocket(4567);
                //调用ServerSocket的accept（）方法，接受客户端发送的请求
                Socket socket = serverSocket.accept();
                //从Socket当中得到InputStream对象
                InputStream inputStream = socket.getInputStream();
                byte buffer[] = new byte[1024*4];
                int temp = 0;
                //从InputStream当中读取客户端所发送的数据
                while ((temp = inputStream.read(buffer)) != -1) {
                    System.out.println(new String(buffer, 0, temp));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
        //UDP协议，包接收，没有流的概念
        public void run() {
            try {
                //创建一个DatagramSocket对象，并指定监听的端口号
                DatagramSocket socket = new DatagramSocket(4567);
                byte data [] = new byte[1024];
                //创建一个空的DatagramPacket对象
                DatagramPacket packet = new DatagramPacket(data, data.length);
                //receive方法用空的对象接收客户发送的数据
                socket.receive(packet);
                System.out.println(packet.getLength());
                String result = new String(packet.getData(), packet.getOffset(), packet.getLength());
                System.out.println("result -------->" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
