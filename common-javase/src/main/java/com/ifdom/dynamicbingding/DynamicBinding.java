package com.ifdom.dynamicbingding;

/**
 * 动态绑定
 *  编译类型 =  运行类型
 *  属性跟随编译类型，方法跟随运行类型
 * 1.调用对象方法时，该方法会和该对象 内存地址/运行类型 绑定
 * 2.
 */
public class DynamicBinding {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.sum());
        System.out.println(a.sum1());
    }

}
