package com.ifdom.polymorphic;

/**
 * 多态
 */
public class Polymorphic {

    public static void main(String[] args) {

        Person ifredom = new Person("ifredom");

        Dog tom = new Dog("Tom");

        Cat jimmy = new Cat("Jimmy");

        // 向上转型
        Animal jimmy2 = new Cat("Jimmy2");
        jimmy2.eat();
        jimmy2.run();
        jimmy2.sleep();

        // 向下转型
        // 使用向下转型的限制：创建时 jimmy2则使用的是Cat
        Cat jimmy3 = (Cat) jimmy2;
        jimmy3.catchMouse();

        Food bood = new Food("bood");

        Food fish = new Food("fish");

        ifredom.feed( tom, bood);
        ifredom.feed(jimmy,fish);
    }

}
