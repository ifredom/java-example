package com.ifdom.collection;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 实现了 Serializable 串行化，那么可以网络传输
 * String  深入 https://www.bilibili.com/video/BV1fh411y7R8?p=468&spm_id_from=pageDriver
 * StringBuffer 存在堆中，非常量池
 * <p>
 * String 效率差，复用率高
 * StringBuffer 线程安全，增删 ，效率高
 * StringBuilder   线程不安全，效率最高
 * <p>
 * 单线程，大量修改，使用 StringBuilder
 * 多线程，大量修改，使用 StringBuffer
 * 配置信息，String
 */
public class BaseTypes {
    public static void main(String[] args) {
        String sortString = reverse("abcdefgh", 1, 7);

        System.out.println(sortString);
        testInteger();

    }

    private static String reverse(String str, int start, int end) {
        char[] chars = str.toCharArray();
        char temp = ' ';
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }


    /**
     * LocalDate, LocalTime, LocalDateTime
     */
    private static void testDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime now = LocalDateTime.now();
        String str = now.format(dateTimeFormatter);
        System.out.println(str);

        LocalDate now1 = LocalDate.now();
        String str1 = now1.format(dateTimeFormatter1);
        System.out.println(str1);

    }


    private static void testStringBuffer() {
        String str = null;

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
//        StringBuffer stringBuffer2 = new StringBuffer(str);
        StringBuilder stringBuilder = new StringBuilder();

    }


    private static void testString() {
        String a = "ayz";
        String b = new String("ayz");

        System.out.println(a == "ayz"); // T
        System.out.println(a == b); // f
        System.out.println(a == b.intern()); // t
        System.out.println(b == b.intern());  // f


        String m = "abc";
        String n = "def";
        String q = m + n;
        String p = "abcdef";
        System.out.println(q == p); // f
    }

    // -128-127使用缓存数据，也就是常量池中的数据
    private static void testInteger() {
        Integer integer = Integer.valueOf(127);
        Integer integer2 = 127;
        System.out.println(integer == integer2); // true


        Integer integer3 = Integer.valueOf(128);
        Integer integer4 = 128;
        System.out.println(integer3 == integer4); // false

    }
}
