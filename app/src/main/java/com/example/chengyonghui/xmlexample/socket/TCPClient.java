package com.example.chengyonghui.xmlexample.socket;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by chengyonghui on 2017/9/19.
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            //创建一个Socket对象，指定服务器端的IP地址和端口号
            Socket socket = new Socket("192.168.1.104", 4567);
            //使用InputStream读取硬盘的文件
            InputStream inputStream = new FileInputStream("f://file/words.txt");
            //从socket当中得到OutputStream
            OutputStream outputStream = socket.getOutputStream();
            byte buffer [] = new byte[4*1024];
            int temp = 0;
            //将InputStream当中的数据取出，并写入到OutputStream当中
            while ((temp = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, temp);
            }
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
