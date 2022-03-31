package com.ifdom.polymorphic;

public class Fish extends Food{
    public Fish(String name) {
        super(name);
    }

    public  void swing(){
        System.out.println(this.name +" is swing");
    }
}
