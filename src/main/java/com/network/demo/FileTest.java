package com.network.demo;


import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        create01();
    }

    public static void create01() {
        String filePath = "D:\\Aworkspace";
        String fileName = "news01.txt";
        File file = new File(filePath, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getFileInfo() {
        File file = new File("D:\\Aworkspace\\news01.txt");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.exists());

        if(file.exists()){
            if(file.delete()){

            }else{
                System.out.println("delete fail");
            }
        }
    }
}
