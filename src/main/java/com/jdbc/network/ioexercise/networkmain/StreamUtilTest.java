package com.jdbc.network.ioexercise.networkmain;

import java.io.*;

public class StreamUtilTest {

    /**
     * stream转化为字节数组
     *
     * @param is
     * @return
     * @throws IOException
     */
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();// 创建输出流
        byte[] buffer = new byte[1024]; // 字节数组
        int len = 0;
        // read()方法是有参数的！
        while ((len = is.read(buffer)) != -1) {
            bos.write(buffer,0,len);
        }
        byte[] array = bos.toByteArray();//输出流转换为数组
        bos.close();
        return array;
    }

    /**
     * stream 转化为 字符串
     * @param is
     * @return
     * @throws IOException
     */
    public static String streamToString(InputStream is) throws IOException {
        BufferedReader stream = new BufferedReader(new InputStreamReader(is));
        StringBuffer stringBuffer = new StringBuffer();

        String line;
        while ((line = stream.readLine()) != null) {
            stringBuffer.append(line + "\r\n");
        }
        return stringBuffer.toString();
    }
}
