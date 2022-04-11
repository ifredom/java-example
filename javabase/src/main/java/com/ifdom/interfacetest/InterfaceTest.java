package com.ifdom.interfacetest;


/**
 * 匿名内部类
 */
public class InterfaceTest {

    public static void main(String[] args) {


        // 外部类直接使用内部静态类
        OuterClass.Inner x = new OuterClass.Inner();
        x.test();

        alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

        alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课");
            }
        });
    }

    public static void alarmClock(Bell bell) {
        bell.ring();
    }

}


class OuterClass {
    private static String name = "outerClass";

    public static class Inner {
        void test() {
            System.out.println("inner " + name);
        }
    }
}

interface Bell {
    void ring();
}
