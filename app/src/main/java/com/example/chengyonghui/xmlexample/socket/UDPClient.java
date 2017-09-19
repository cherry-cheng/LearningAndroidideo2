package com.example.chengyonghui.xmlexample.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by chengyonghui on 2017/9/19.
 */
public class UDPClient {
    public static void main(String[] args) {
        try {
            //首先创建一个DatagramSocket对象
            DatagramSocket socket = new DatagramSocket(4567);
            //创建一个InetAddress
            InetAddress serverAddress = InetAddress.getByName("192.168.1.104");
            String str = "hello";
            //拆分成字节数组
            byte data [] = str.getBytes();
            //创建一个DatagramPacket对象，并指定要将这个数据包发送到网络中的哪个地址和端口号
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, 4567);
            //调用socket对象的send方法，发送数据
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
