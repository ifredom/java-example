package com.jdbc.network.ioexercise.networkmain;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpSocketByteClient {
    public static void main(String[] args) throws IOException {


        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        System.out.println("客户端连接到服务端");


        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, socket java。。。".getBytes());
        System.out.println("成功发送数据");
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }

        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
