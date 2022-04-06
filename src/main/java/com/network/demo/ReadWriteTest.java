package com.network.demo;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class ReadWriteTest {
    public static void main(String[] args) {

    }

    @Test
    public void testRead() {
        String filePath = "D:\\Aworkspace\\story.txt";
        FileReader fileReader = null;
        int data = 0;
        try {
            fileReader = new FileReader(filePath);

            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void testRead01() {
        String filePath = "D:\\Aworkspace\\story.txt";
        FileReader fileReader = null;
        int dataLen = 0;
        char[] buf = new char[8];
        try {
            fileReader = new FileReader(filePath);

            while ((dataLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, dataLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
