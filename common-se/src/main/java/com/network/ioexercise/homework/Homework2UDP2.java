package com.network.ioexercise.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Homework2UDP2 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(7704);
        byte[] bytes = "hello, UDP编程".getBytes();

        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("172.17.9.225"),7703);

        socket.send(packet);

        socket.close();
    }
}
