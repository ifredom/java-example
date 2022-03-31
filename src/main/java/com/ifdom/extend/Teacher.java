package com.ifdom.extend;

public class Teacher {
    public String name;
    private String alis;

    public Teacher(String name) {
        this.name = name;
    }

    public void fun1(String something) {
        System.out.println(" Teacher fun1" + something);
    }

    private void fun2() {
        System.out.println("fun2");
    }

}
