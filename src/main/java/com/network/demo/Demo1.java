package com.network.demo;

import java.io.File;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) {

    }

    public void create01() {
        String parantPath = "e:\\";
        String fileName = "news01.txt";
        File file = new File(parantPath
                , fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
