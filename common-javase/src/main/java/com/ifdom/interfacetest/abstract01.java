package com.ifdom.interfacetest;


/**
 * 抽象类
 *
 * 目的： 抽象类强调所属关系
 *
 * 1. 对子类而言，只能继承一个抽象类
 * 1. 对抽象类而言，抽象类中可以含有非抽象方法，非抽象方法属于普通方法，可以有方法体，不必被子类实现
 * 2. 对抽象类而言，抽象类中用 abstract修饰的方法 ，不能有方法体，该方法必须被子类实现
 * 3.抽象类中用 abstract修饰的方法，不能被private、static、synchronized和native等修饰
 */
public abstract class abstract01 {

    int num = 2;

    public void contect() {
        System.out.println("123");
    }
}
