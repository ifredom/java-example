package com.network.ioexercise;


import org.junit.Test;

import java.io.*;

/**
 * 转换流
 *
 *
 * 字节流转换成字符流
 */
public class TransformationTest {
    public static void main(String[] args) throws Exception{
        String filePath = "D:\\a.txt";
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"GBK"));

        String s = inputStreamReader.readLine();
        System.out.println(s);
        inputStreamReader.close();

    }

    // 设置 charset
    @Test
    public  void testWrite() throws Exception{
        String filePath = "D:\\a.txt";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath),"utf-8");

        osw.write("打印");
        osw.close();
    }

    // 设置 charset
    @Test
    public  void testPrintStream() throws IOException {
        PrintStream printStream = System.out;

        printStream.print("123");
        printStream.write("java 你好".getBytes());
        printStream.close();


        // 系统输出流默认设备未显示器，修改为文本
        System.setOut( new PrintStream("D:\\f1.txt"));
        // 因此打印会打印到文本当中
        System.out.println("日志输出");
    }


}
