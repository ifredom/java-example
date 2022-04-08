package com.jdbc.network.ioexercise.networkmain;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUploadClient {
    public static void main(String[] args) throws IOException {
        // 1. 客户端连接
        Socket socket = new Socket(InetAddress.getLocalHost(),7888);

        // 2. 获取磁盘文件的输入流
        String filePath = "D:\\pic.png";
        BufferedInputStream fileStream = new BufferedInputStream(new FileInputStream(filePath));
        byte[] byteArray = StreamUtilTest.streamToByteArray(fileStream);

        // 3.通过socket获取输出流，将bytes数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(byteArray); // 将文件对应的字节数组数据写入通道
        fileStream.close();
        bos.flush();
        socket.shutdownOutput();// 设置写入数据的结束标记

        System.out.println("客户端: 图片发送完成");

        InputStream bis = socket.getInputStream();
        String s = StreamUtilTest.streamToString(bis);

        System.out.println(s);

        bis.close();
        bos.close();
        socket.close();
    }
}
