package com.ifdom.interfacetest;

/**
 * 接口
 * 目的： 设计约束，设计好各种规范，让其他类去实现这种方法
 * 接口 是对单继承的一种扩展
 * 继承主要价值在于：解决代码复用性和可维护性
 *
 * 1. 接口不能被实例化
 * 2. 接口中的所有方法都是 public abstract ， abstract 被省略
 * 3. 抽象类 interface 接口后，可以不实现接口方法
 * 4. 接口中的属性都是 public static final num =1 (并且必须被初始化)
 *
 *
 */
public interface Interface01 {
    int num = 1;

    public void connect();

    public void dispose();
}
