package com.ifdom;

/**
 * 实现了 Serializable 串行化，那么可以网络传输
 * String  深入 https://www.bilibili.com/video/BV1fh411y7R8?p=468&spm_id_from=pageDriver
 * StringBuffer 存在堆中，非常量池
 *
 * String 效率差，复用率高
 * StringBuffer 线程安全，增删 ，效率高
 * StringBuilder   线程不安全，效率最高
 *
 * 单线程，大量修改，使用 StringBuilder
 * 多线程，大量修改，使用 StringBuffer
 * 配置信息，String
 */
public class BaseTypes {
    public static void main(String[] args) {
        testStringBuffer();
    }




    private static  void testStringBuffer(){
        String str =null;

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
//
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
}
