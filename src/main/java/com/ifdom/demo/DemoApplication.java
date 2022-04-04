package com.ifdom.demo;

import com.ifdom.designmode.SingleInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);

//        testCompare();
        String  test = "1234";

        byte[] bytes =  {'1','2','3','4'};

        System.out.println(bytes.toString());
        System.out.println(test.equals(bytes.toString()) );

        BigInteger bigInteger = new BigInteger("123");

    }

    public static void testCompare() {
        Book[] books = new Book[4];
        books[0] = new Book("hh", 100);
        books[1] = new Book("xx", 300);
        books[2] = new Book("aa", 900);
        books[3] = new Book("tt", 200);

        for (Book item : books) {
            System.out.println(item);
        }

        test2(books);

        for (Book item : books) {
            System.out.println(item);
        }
        System.out.println("\n==============");
        Book[] latest = Arrays.copyOf(books,2);
        for (Book item : latest) {
            System.out.println(item);
        }

    }

    public static void test2(Book[] books) {
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                int result = 0;
                if (o1.price - o2.price > 0) {
                    result = 1;
                } else if (o1.price - o2.price < 0) {
                    result = -1;
                } else {
                    result = 0;
                }
                return result;
            }
        });
    }

}

class Book {
    public String name;
    public int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Book() {
        System.out.println("TestArrays constructor");
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}