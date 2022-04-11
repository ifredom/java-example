package com.ifdom.houserent;

import java.util.Scanner;

public class HouseView {
    private boolean loop = true;
    private String key = "";
    private HouseService houseService = new HouseService(10);
    Scanner scanner;

    public void mainMenu() {
        showMainMenu();

        scanner = new Scanner(System.in);


        do {
            key = scanner.next();
            switch (key) {
                case "1":
                    addHouse();
                    showMainMenu();
                    break;
                case "2":
                    System.out.println("输入房屋编号:");
                    int id = scanner.nextInt();
                    House findHouse = findHouse(id);
                    System.out.println("找到房屋"+findHouse +'\n');
                    showMainMenu();
                    break;
                case "3":
                    System.out.println("输入房屋编号:");
                    int houseId = scanner.nextInt();
                    removeHouse(houseId);
                    showMainMenu();
                    break;
                case "4":
                    System.out.println("输入房屋编号:");
                    int hId = scanner.nextInt();
                    System.out.println("输入房主名称:\n");
                    String newName = scanner.next();
                    updateHouseName(hId, newName);
                    showMainMenu();
                    break;
                case "5":
                    showHouseList();
                    break;
                case "6":
                    System.out.println("退  出");
                    loop = false;
                    break;
            }
        } while (loop);

    }

    public void showMainMenu() {
        System.out.println("===========房屋出租系统=========");
        System.out.println("\t\t\t1. 新增房源");
        System.out.println("\t\t\t2. 查找房源  ");
        System.out.println("\t\t\t3，删除房屋信息");
        System.out.println("\t\t\t4. 修改房屋信息");
        System.out.println("\t\t\t5. 房屋列表");
        System.out.println("\t\t\t6. 退  出");
        System.out.println("请输入你的选择:\n");
    }

    public boolean addHouse() {
        System.out.println("输入房屋编号:");
        int id = scanner.nextInt();
        System.out.println("输入房主:");
        String name = scanner.next();
        System.out.println("输入电话:");
        String phone = scanner.next();
        System.out.println("输入地址:");
        String address = scanner.next();
        System.out.println("输入月租:");
        int rent = scanner.nextInt();
        System.out.println("输入状态:");
        String status = scanner.next();

        House house = new House(id, name, phone, address, rent, status);

        houseService.add(house);
        System.out.println("===========房屋添加成功=========");
        return true;
    }

    public void removeHouse(int id) {
        houseService.del(id);
    }

    public House findHouse(int id) {
        House house = houseService.findById(id);
        return house;
    }

    public void updateHouseName(int id, String newName) {
        houseService.updateNameById(id, newName);

    }


    public void showHouseList() {
        System.out.println("===========房屋列表=========");
        System.out.println("编号  房主  电话  地址  月租 状态（未出租/已出租）");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("===========房屋列表显示完毕=========");
    }

    public int receive(int input) {

        return input;
    }
}
