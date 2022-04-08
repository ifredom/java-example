package com.jdbc.network.ioexercise.networkmain;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CharSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器等待连接中，一旦链接");

        // 此时处于阻塞装填，必须要由客户端连接后，解除阻塞
        Socket socket = serverSocket.accept();
        System.out.println("已有客户端连接！" + socket.getClass());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String readLine = bufferedReader.readLine();
        System.out.println(readLine);


        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("字符流：服务端发送的返回信息");
        bufferedWriter.newLine(); // 插入换行符，表示写入内容结束
        bufferedWriter.flush();// 使用字符流，需要手动刷新，否则不会将数据写入通道


        // 关闭流和socket
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
    }
}
