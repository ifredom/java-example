package com.jdbc.network.ioexercise;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {


        String filePath = "D:\\javatest.properties";

        Properties properties = new Properties();
        properties.load(new FileReader(filePath));
        properties.list(System.out);

        System.out.println(properties.getProperty("username"));
    }

    @Test
    public void saveProperties() throws IOException {
        Properties properties = new Properties();

        properties.setProperty("user","if dom");
        properties.setProperty("pwd","123");

        properties.store(new FileOutputStream("D:\\javatest.properties"),"comment 注释内容");

    }
}
