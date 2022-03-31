package com.ifdom.demo;


/**
 * 汉诺塔问题
 * 1. 三根柱子，将第一根柱子的所有盘子移动到第三根柱子上
 * 2. 一次只能移动一个盘子
 * 3. 大盘子只能在小盘子下面
 * 4. 核心思想  将多个盘子视作一个整体，作为一个盘子。始终最多视为2个盘子
 */
public class HanoiTower {


    /**
     *
     * @param n 共有n个盘子
     * @param from  开始的柱子 A
     * @param in  中间的柱子 B
     * @param to  目标柱子 C
     */
    public void move(int n ,char from ,char in, char to){
        if(n==1){
            System.out.println("第"+n+"个盘子从"+from+"移动到"+to);
        }else{
            // 移动上面的所有盘子
            // 上面的盘子从A移动B，那么C就变成了中间柱子
            move(n-1,from,to,in);
            System.out.println("第"+n+"个盘子从"+from+"移动到"+to);
            move(n-1,in,from,to);
        }
    }

}
