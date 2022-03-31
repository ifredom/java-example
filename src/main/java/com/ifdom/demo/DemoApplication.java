package com.ifdom.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
        int[] arr ={1,2,3,4};
        int y = test(arr);
        System.out.println(y);

    }

    private static int test(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max  = arr[i];
            }
        }
        return max;
    }


}


class Person {
    String name;
    int age;

    Person() {
    }

    Person(String name) {
        this.name = name;
        this.age = 18;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    boolean compareTo(Person b) {
        return this.name.equals(b.name) && this.age == b.age;
    }
}



