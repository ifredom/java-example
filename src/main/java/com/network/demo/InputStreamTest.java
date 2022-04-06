package com.network.demo;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class InputStreamTest {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() {
        String filePath = "D:\\Aworkspace\\news01.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);

            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                fileInputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void readFile02() {
        String filePath = "D:\\Aworkspace\\news01.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        byte[] buf = new byte[8];
        int readLen = 0;
        try {
            fileInputStream = new FileInputStream(filePath);

            while ((readLen = fileInputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                fileInputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void readFile03() {

        FileOutputStream fileOutputStream = null;

        try {
            File file = new File("D:\\Aworkspace\\news02.txt");

            fileOutputStream = new FileOutputStream(file, true);

            String str = " hsp world";
            fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                fileOutputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 拷贝
     */
    @Test
    public void readFile04() {
        String filePath = "D:\\Aworkspace\\download.jpg";
        String destPath = "D:\\Aworkspace\\download2.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        // 定义一个字节数组
        byte[] buf = new byte[1024];
        try {
            File file = new File(filePath);

            fileInputStream = new FileInputStream(filePath);
            fileOutputStream = new FileOutputStream(destPath);

            while (fileInputStream.read(buf) != -1) {
                fileOutputStream.write(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
