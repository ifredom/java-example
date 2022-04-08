package com.jdbc.network.ioexercise.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1.使用字符流编写客户端
 * 2.客户端发送anme, 服务端收到后,返回我是nova,
 * 3.客户端发哦是那个 hobby ,服务端接收后,返回 编写Java程序
 * 4. 不是这两个问题,回复你说啥呢
 *
 * 怎么循环多次?
 */
public class Homework1Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 7701);


        BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        Scanner scanner = new Scanner(System.in);
        String question = scanner.next();

        bos.write(question);
        bos.newLine();// 插入一个换行符表示内容结束,注意:要求对方使用readLine()
        bos.flush();
//        socket.shutdownOutput();


        BufferedReader bis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = bis.readLine();

        System.out.println(s);

        bis.close();
        bos.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
