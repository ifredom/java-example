package com.ifdom.demo;

import com.ifdom.designmode.SingleInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);

        SingleInstance test = SingleInstance.getInstance("小红");
        SingleInstance test2 = SingleInstance.getInstance("小绿");

        System.out.println(test);
        System.out.println(test2);
        System.out.println(test == test2);
    }
}

class Test {

    public Test() {
        System.out.println("Test constructor");
    }

    {
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
    }
}