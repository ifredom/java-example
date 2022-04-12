package com.network.ioexercise.networkmain;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        InetAddress byName = InetAddress.getByName("DESKTOP-JGOIO2U");
        System.out.println(byName);

        InetAddress baiduName = InetAddress.getByName("www.baidu.com");
        System.out.println(baiduName);

        System.out.println(baiduName.getHostAddress());

        System.out.println(baiduName.getHostName());

    }
}
