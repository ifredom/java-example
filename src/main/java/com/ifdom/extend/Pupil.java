package com.ifdom.extend;

public class Pupil extends Teacher {
    public String name;

    public Pupil(String name) {
        super(name);
        this.name = "jack";
    }

    public void fun1() {
        System.out.println("Pupil fun1");

        System.out.println("Pupil fun1 call " + super.name);
    }

    @Override
    public void fun1(String something) {
        System.out.println("Pupil fun1 override");

        System.out.println("Pupil fun1 override call " + super.name);
    }
}
