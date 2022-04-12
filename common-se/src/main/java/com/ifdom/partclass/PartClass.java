package com.ifdom.partclass;

/**
 * 内部类（难点，重点）
 *
 * <p>
 * 面向对象的：最难分水岭
 * <p>
 * 类的五大成员：属性，方法，构造器，代码块，内部类
 * <p>
 * 1. 局部内部类（）
 * 2. 匿名内部类
 * <p>
 * 3. 成员内部类（没有static）
 * 4. 静态内部类（有static）
 */
public class PartClass {
    public static void main(String[] args) {
        Outer outer = new Outer(10);


    }
}

class Outer {
    private int n1 = 100;// 属性

    public Outer(int n1) {
        this.n1 = n1;
    }

    public void m1() {// 方法
        System.out.println("m1");
        class ParClass1 {
            String name;
            public ParClass1(String name) {
                this.name = name;
            }
        }
        ParClass1 partClass = new ParClass1("ifs");
    }

    {// 代码块
        System.out.println("部分代码块");
    }

    class Inner { // 内部类
    }
}