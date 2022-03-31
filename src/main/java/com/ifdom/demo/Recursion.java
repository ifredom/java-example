package com.ifdom.demo;

import lombok.extern.slf4j.Slf4j;


/**
 * 递归 : https://www.bilibili.com/video/BV1fh411y7R8?p=216&spm_id_from=pageDriver
 * 使用栈结构执行：  先进后出。 先创建栈存储空间
 * 打印问题
 */
@Slf4j
public class Recursion {
    public void test(int n) {
        if (n > 1) {
            test(n - 1);
            log.info("here:" + String.valueOf(n));
        } else {
            log.info(String.valueOf(n));
        }
    }

    public int factorial(int n) {
        if (n == 1) {
            return 2;
        } else {
            return factorial(n - 1) * n;
        }
    }

    /**
     * 斐波那契额数列
     * ? 给定一个数，求它的斐波那契数列的值
     * 1,1,2,3,5,8,13,21。。。
     * 1. when n==1 , fabonacci value is 1
     * 2. when n==2 , fabonacci value is 1
     * 3. when n>=3 , fabonacci value is (prev value) + (prev+1) value
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        if (n >= 1) {
            if (n == 1 || n == 2) {
                return 1;
            } else {
                return fibonacci(n - 2) + fibonacci(n - 1);
            }
        } else {
            return -1;
        }
    }

    /**
     * 猴子吃桃
     * ? 每天吃一半，再多吃一个，一共10天，最后剩下一个，求最初总数量？
     * 1. day = 10, 1
     * 2. day = 9, return (day8+1)*2
     * 3. day = 8, return (day7+1)*2
     *
     * @param day
     * @return
     */
    public int monkeyEatPeach(int day) {
        if (day == 10) {
            return 1;
        } else {
            return (monkeyEatPeach(day + 1) + 1) * 2;
        }
    }
}