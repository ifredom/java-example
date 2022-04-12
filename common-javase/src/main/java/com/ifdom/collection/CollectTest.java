package com.ifdom.collection;


import java.util.*;

/**
 * 集合
 * <p>
 * 难点：
 * 1. 底层机制理解
 * 2. 应用场景 大部分都是改查，所以使用arrayList
 * <p>
 * Collection:
 * 1. [List] ： Vector, ArrayList, LinkedList
 * 2. [set] ： TreeSet, HashSet
 * 3. [Map] : hashMap, HashTable, TreeMap | Properties, LinkedHashMap
 * <p>
 * 分类 ：单列集合，双列集合
 *
 *
 *  Vector: 线程安全，效率不高  扩容机制: 基础大小 10 + X * 2
 *  ArrayList: 线程不安全， 效率高  扩容机制: 基础大小 10 + X * 1.5
 *  LinkedList: 线程不安全，效率最高(增删) 效率最低（该查）， 底层机制 双向链表 和 双端队列
 *
 *
 *  使用：
 *  单列允许重复：
 *  增删多 LinkedList
 *  改查多 ArrayList
 *
 *  不允许重复
 *  无序： HashSet
 *  排序： TreeSet
 *  插入取出顺序一致 LinkedHashSet
 *
 *  双列
 *  键无序： HashMap
 *  键有序： TreeMap
 *  插入取出顺序一致: LinkedHashMap
 */
public class CollectTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        debugList();

    }

    private static void debugList() {
        List arrayList = new LinkedList();


        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        for (int i = 10; i < 15; i++) {
            arrayList.add(i);
        }
    }


    private static void testVector() {
        List xx = new ArrayList(-1);
//        List<Book> arrayList = new Vector();
        List<Book> arrayList = new ArrayList();
//        List<Book> arrayList = new LinkedList();
        arrayList.add(new Book("三国演义", "罗贯中", 25));
        arrayList.add(new Book("红楼梦", "曹雪芹", 45));
        arrayList.add(new Book("西游记", "吴承恩", 31));
        arrayList.add(new Book("金瓶梅", "吴承恩", 1));
        arrayList.add(new Book("人间失格", "吴承恩", 17));

        System.out.println(arrayList);
        for (Book o : arrayList) {
            System.out.println(o);
        }
        System.out.println("---------------");
        testVectorSort(arrayList);

        for (Book o : arrayList) {
            System.out.println(o);
        }
    }
    // 排序
    private static void testVectorSort(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if (book1.getSalary() > book2.getSalary()) {
                    list.set(j, book2);
                    list.set(j + 1, book1);

                }
            }
        }
    }


    private static void testList() {
        List arrayList = new ArrayList();

        arrayList.add(new Book("三国演义", "罗贯中", 25));
        arrayList.add(new Book("红楼梦", "曹雪芹", 45));
        arrayList.add(new Book("西游记", "吴承恩", 31));

        System.out.println(arrayList);
    }

    private static void testIterator() {
        Collection arrayList = new ArrayList();

        arrayList.add(new Book("三国演义", "罗贯中", 25));
        arrayList.add(new Book("红楼梦", "曹雪芹", 45));
        arrayList.add(new Book("西游记", "吴承恩", 31));

        Iterator iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println("---------------");

        // 希望再次遍历，需要充值迭代器
        iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println("---------------");
        for (Object o : arrayList) {
            System.out.println(o);
        }


    }

    private static void testArrayList() {


        ArrayList arrayList = new ArrayList();

        arrayList.add("jack");
        arrayList.add(10);
        arrayList.add(true);
        arrayList.add("tom");
        arrayList.add(4);

        System.out.println(arrayList);

        arrayList.remove(2);

        System.out.println(arrayList);


        boolean findResult = arrayList.contains("jack");
        System.out.println(findResult);

    }
}


class Book {
    private String name;
    private String author;
    private double salary;

    Book(String name, String author, double salary) {
        this.name = name;
        this.author = author;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", salary=" + salary +
                '}';
    }
}