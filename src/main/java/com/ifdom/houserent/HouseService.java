package com.ifdom.houserent;

public class HouseService {
    private House[] houses;
    private int houseNums = 1; // 房屋数量
    private int idCounter = 1; // id自增长的机制

    public HouseService(int size) {
        this.houses = new House[size];

        houses[0] = new House(1, "jack", "131", "东京", 2000, "未出租");
    }

    public House[] list() {
        return houses;
    }

    public boolean add(House house) {

        houses[idCounter] = house;
        idCounter++;
        house.setId(idCounter);

        houseNums++;
        return true;
    }

    public void del(int houseId) {
        int findIndex = -1;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getId() == houseId) {
                findIndex = i;
                break;
            }
        }
        // 将数组后一项，往前移一项，并将最后一个置空
        for (int i = findIndex; i < houses.length - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNums] = null;
    }

    public House findById(int houseId) {
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getId() == houseId) {
                return houses[i];
            }
        }
        return null;
    }

    public void updateNameById(int houseId, String newName) {
        int findIndex = -1;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getId() == houseId) {
                findIndex = i;
                break;
            }
        }


        houses[findIndex].setName(newName);
    }

}
