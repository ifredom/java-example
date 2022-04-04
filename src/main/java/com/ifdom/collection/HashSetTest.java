package com.ifdom.collection;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * Set
 * <p>
 * 1. HashSet
 * 2. LinkedHashSet
 * <p>
 * 取出来的顺序是固定的，但不是添加的顺序
 * <p>
 * HashSet 底层是 HashMap, 数组 + 链表
 */
public class HashSetTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        testSet2();
    }

    /**
     * 测试将数据添加到一条链表上，何时转换为红黑树?
     * 长度 >=64时转换
     */
    private static void testSourceCodeLinked() {


        HashSet<A> ac = new HashSet<A>();

        for (int i = 0; i < 100; i++) {
            ac.add(new A(i));
        }
    }

    /**
     * 源码演示： 数组+链表
     * 1. 添加元素时，先计算 hashCode ,转换成索引值
     * 2. 在存储的表table中查找对应索引值所在空间，是否已存数据
     * 3. 如果有数据，那么调用equals()比较，不太相同，则添加到链后（equals由程序员重写自定义）
     * 4. JAVA8中，如果一个链表长度超过8，并且 table 数组大小 >= 64，就会进行树化（红黑树）
     * 6. table数组size到了临界值12 （链表上的数据也会导致size++），会扩容到 16*2 =32，新的临界值时 32*0.75=24
     */
    private static void testSourceCodeSet() {
        Node[] table = new Node[16];

        Node john = new Node("john", null);
        Node tom = new Node("tom", null);
        Node rose = new Node("rose", null);

        table[2] = john;
        john.next = tom;
        tom.next = rose;

        HashSet table2 = new HashSet();
        table2.add("jerry");
        table2.add("tom");
        table2.add("jerry");
    }

    private static void testSet() {
        HashSet hashSet = new HashSet();

        hashSet.add("tom");
        hashSet.add("jack");
        hashSet.add("jenny");
        hashSet.add("tom");
        hashSet.add("dom");
        hashSet.add(null);

        System.out.println(hashSet);


        // 迭代方式一
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
        }

        // 迭代方式二
        for (Object o : hashSet) {
            System.out.println(o);
        }


        hashSet.add(new String("ifdom")); // ok
        hashSet.add(new String("ifdom")); // ? false

    }
    private static void testSet2() {
        HashSet hashSet = new HashSet();

        Employee tom = new Employee("tom", 1,new MyDate("1991-01-02"));
        Employee jack = new Employee("jack", 2,new MyDate("1991-01-02"));
        Employee jenny = new Employee("jenny", 3,new MyDate("1991-01-02"));

        hashSet.add(tom);
        hashSet.add(jack);
        hashSet.add(jenny);

        Employee jenny2 = new Employee("jenny", 2,new MyDate("1991-01-03"));

        hashSet.add(jenny2);

        Employee jenny3 = new Employee("jenny", 3,new MyDate("1991-01-02"));

        hashSet.add(jenny3);

        for (Object employee :hashSet) {
            System.out.println(employee);
        }


    }
}


class Node {
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}


class A {
    private  int n;

    public A(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}

class Employee{
    private String name;
    private int age;
    private MyDate birth;

    public Employee(String name, int age, MyDate birth) {
        this.name = name;
        this.age = age;
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(birth, employee.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birth);
    }
}

class MyDate{
    private String birth;

    public MyDate(String birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return Objects.equals(birth, myDate.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birth);
    }
}