package com.ifdom.polymorphic;

public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    // 核心，使用父类作为参数
    public void feed(Animal animal, Food food) {
        System.out.println("主人 " + this.name + " is feed " + animal.name + " " + food.name);
    }
}
