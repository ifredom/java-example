package com.network.demo;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\Aworkspace\\news01.txt"));
        String line = "";

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }
}
