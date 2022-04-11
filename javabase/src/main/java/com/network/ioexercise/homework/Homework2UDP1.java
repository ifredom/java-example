package com.network.ioexercise.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP
 * 1.使用UDP完成,在  7703 端口监听数据,另一端在7704端口
 * 2.发送端向接收端发送数据 四大名著是哪些
 * 3.接收端收到发送端发送的问题后,返回 四大名著是 红楼梦,否则返回what?
 * 4.两端同时退出
 *
 * 怎么循环多次?
 */
public class Homework2UDP1 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(7703);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        socket.receive(packet);


        int length = packet.getLength();
        byte[] data = packet.getData();

        System.out.println(length);
        System.out.println(data);
        String s = new String(data, 0, length);

        // 构造stringBuffer 无法显示为字符串
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(data.toString());


        System.out.println(s);
        System.out.println(stringBuffer.toString());
        socket.close();
    }
}
