package com.jdbc.network.upload;

import java.io.*;

public class StreamUtils {

    /**
     * 输入流转换成byte[]
     *
     * @param is
     * @return
     * @throws IOException
     */
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = is.read(bytes)) != -1) {
            bos.write(bytes, 0, readLen);
        }
        byte[] array = bos.toByteArray();
        bos.close();
        return array;
    }

    /**
     * 输入流转换成字符串
     * @param is
     * @return
     * @throws IOException
     */
    public static String streamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String result;
        StringBuilder stringBuilder = new StringBuilder();
        while ((result = reader.readLine()) != null) {
            stringBuilder.append(result + "\r\n");
        }
        return stringBuilder.toString();
    }
}
