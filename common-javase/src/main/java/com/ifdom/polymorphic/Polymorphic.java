package com.ifdom.polymorphic;

/**
 * 多态
 *
 * 接口 与 继承  在多态方面的区别，在下方。
 * 接口的多态传递现象：接口也可以使用extend去继承接口
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



        // 演示接口的多态性
        IF monster = new Monster();
        IF bird = new Bird();
        monster = new Bird();

        // 演示继承的多态性
        AA aa = new BB();
        AA cc = new CC();
        aa = new CC();

    }

}


interface IF{}
class Monster implements IF{}
class Bird implements IF{}


class AA{}
class BB extends AA{}
class CC extends AA{}