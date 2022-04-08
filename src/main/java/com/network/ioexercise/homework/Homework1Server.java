package com.network.ioexercise.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework1Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7701);

        Socket socket = serverSocket.accept();


        BufferedReader bis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = bis.readLine();
        String answer;

        if (s.equals("name")) {
            answer = "name";
        } else if (s.equals("hobby")) {
            answer = "编写java程序";
        } else {
            answer = "你说啥";
        }

        System.out.println(s);

        BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bos.write(answer);
        bos.newLine();
        bos.flush();

        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();

    }
}
