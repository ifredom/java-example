package com.ifdom.demo;

import com.ifdom.extend.Pupil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);

        Pupil pupil = new Pupil("jack");
        log.info(pupil.name);
        pupil.fun1();
        pupil.fun1();
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum+=i;
            System.out.println(i);

        }

        System.out.println(sum);
    }



}