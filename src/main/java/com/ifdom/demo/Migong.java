package com.ifdom.demo;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Migong {


    /**
     * 创建迷宫，0表示不能通行，1表示可以通行
     */
    public void initMiGong() {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

//        map[6][4] = 1;
        map[5][5] = 1;

        System.out.println("======地图==========");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(String.valueOf(map[i][j]) + " ");
            }
            System.out.println("");
        }


        MiGongBall miGongBall = new MiGongBall();

        boolean result = miGongBall.findMap(map, 1, 1);

        System.out.println("======找路的情况==========");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(String.valueOf(map[i][j]) + " ");
            }
            System.out.println("");
        }


    }
}


class MiGongBall {
    /**
     * 使用递归思想来解决老鼠出迷宫
     * 1. 起始位置在 （1,1）, 出口（6，5）
     * 2. 0 无障碍物 1 有障碍物 2表示可以走 3表示走不通，死路
     * 3. 当map[6,5] ==2 时，表示找到出口，否则继续找
     * 4. 确定老鼠找路策略  下 -> 右 -> 上 -> 左  （可以修改策略）
     * 5. 测试回溯现象
     * 6.思考：如何找到最短路径？  1.穷举法 2，图
     */

    public boolean findMap(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                // 假定可以走
                map[i][j] = 2;

                if (findMap(map, i+1, j )){ // 先走右
                    return true;
                } else if (findMap(map, i,j+1)) {// 走下
                    return true;
                } else if (findMap(map, i - 1, j)) {// 走上
                    return true;
                } else if (findMap(map, i, j - 1)) {// 走左
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }

            } else {
                return false;
            }
        }
    }

}