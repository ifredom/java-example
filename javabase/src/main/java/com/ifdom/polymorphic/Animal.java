package com.ifdom.polymorphic;

public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public  void eat() {
        System.out.println(this.name +" is eat");
    }
    public  void run() {
        System.out.println(this.name +" is run");
    }
    public  void sleep() {
        System.out.println(this.name +" is sleep");
    }
}
