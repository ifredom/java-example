package com.network.ioexercise.networkmain;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1. 编写服务端和客户端，服务器再9999端口监听
 * 2. 客户端连接服务端，发送一张图片 D:\\pic.png
 * 3. 服务端收到图片保存再src下，返回 “收到图片”在退出
 * 4.客户端收到服务端的消息后退出
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws IOException {

        System.out.println("服务器已创建");
        // 1. 服务端在本机监听 9999 端口
        ServerSocket serverSocket = new ServerSocket(7888);

        // 2. 等待连接
        Socket socket = serverSocket.accept();

        System.out.println("客户端已连接");

        // 3. 读取客户端发送的数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

        byte[] bytes = StreamUtilTest.streamToByteArray(bis);
        System.out.println(bytes.length);

        // 4. 得到 byteArray,写入指定路径
        String destFilePath = "src\\copy.png";
        BufferedOutputStream saveStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
        saveStream.write(bytes);
        saveStream.close();
        System.out.println("服务端收到图片，并保存完毕");

        // 4. 给客户端回复一个收到了的消息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        bufferedWriter.write("服务端: 已经收到图片了\r\n");
        bufferedWriter.flush();


        bufferedWriter.write("服务端: 我还想多说一句");
        bufferedWriter.flush();

//                socket.shutdownOutput();// 设置结束标记

        // 关闭，关闭的时候会自动刷新
        bufferedWriter.close();
        bis.close();
        socket.close();
        serverSocket.close();

    }
}
