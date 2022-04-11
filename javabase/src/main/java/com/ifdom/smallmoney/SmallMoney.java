package com.ifdom.smallmoney;


import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * part335 零钱通
 * 1. 零钱明细
 * 2. 收益入账
 * 3， 消费
 * 4 退出
 */
public class SmallMoney {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        double balance = 0;
        double money = 0;

        String result = "";
        String business = "";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");

        do {
            System.out.println("===========零钱通=========");
            System.out.println("      1. 零钱明细");
            System.out.println("      2. 收益入账  ");
            System.out.println("      3， 消费");
            System.out.println("      4 退出");
            System.out.println("请选择业务");

            key = scanner.next();

            LocalDateTime ldt;
            switch (key) {
                case "1":
                    System.out.println("===========零钱明细=========");
                    System.out.println(result);
                    break;
                case "2":
                    System.out.println("输入收益金额:");

                    money = scanner.nextDouble();
                    balance += money;
                    ldt = LocalDateTime.now();

                    result += "收益入账：  " + money + "  " + dateTimeFormatter.format(ldt) + "\t" + balance+"\n";
//                    System.out.println(result);
                    break;
                case "3":
                    System.out.println("输入消费金额:");
                    money = scanner.nextDouble();
                    System.out.println("输入消费业务:");
                    business = scanner.next();

                    balance -= money;

                    ldt = LocalDateTime.now();
                    result += business+"：   " + money + "    " + dateTimeFormatter.format(ldt) + "  \t" + balance+"\n";
//                    System.out.println(result);
                    break;
                case "4":
                    System.out.println("      4 退出");
                    loop = false;
                    break;
            }

        } while (loop);

        System.out.println("退出");


    }
}
