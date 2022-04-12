package com.network.ioexercise.networkmain;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class CharSocketClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客户端连接到服务端");

        OutputStream outputStream = socket.getOutputStream();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        bufferedWriter.write("hello, socket java。。。");
        bufferedWriter.newLine(); // 插入换行符，表示写入内容结束
        bufferedWriter.flush();// 使用字符流，需要手动刷新，否则不会将数据写入通道
        System.out.println("成功发送数据");


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String readLine = bufferedReader.readLine();
        System.out.println(readLine);

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
