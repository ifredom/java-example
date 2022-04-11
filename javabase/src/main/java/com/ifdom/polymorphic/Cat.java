package com.ifdom.polymorphic;

public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    public  void catchMouse() {
        System.out.println(this.name +" is catchMouse");
    }
}
