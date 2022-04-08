package com.network.ioexercise.networkmain;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket
 * 1. socket.getOutputStream()
 * 2. socket.getInputStream()
 *
 * 设置结束标记：        socket.shutdownOutput();
 */
public class TcpSocketByteServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("服务器等待连接中，一旦链接");

        // 此时处于阻塞装填，必须要由客户端连接后，解除阻塞
        Socket socket = serverSocket.accept();

        System.out.println("已有客户端连接！" + socket.getClass());


        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int redLen = 0;

        while ((redLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, redLen));
        }


        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("服务端已收到".getBytes());
        socket.shutdownOutput();

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
