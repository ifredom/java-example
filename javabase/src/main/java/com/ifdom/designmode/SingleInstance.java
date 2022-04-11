package com.ifdom.designmode;


/**
 * 单例模式
 */
public class SingleInstance {

    private static SingleInstance instance;
    private String name;

    private SingleInstance(String name) {
        this.name = name;
    }

    public static SingleInstance getInstance(String name) {
        if (instance == null) {
            instance = new SingleInstance(name);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "SingleInstance{" +
                "name='" + name + '\'' +
                '}';
    }
}
