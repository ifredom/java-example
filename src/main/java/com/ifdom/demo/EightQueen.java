package com.ifdom.demo;

public class EightQueen {

    /**
     * 八皇后问题
     * https://www.bilibili.com/video/BV1ZK411K7A8?spm_id_from=333.337.search-card.all.click
     * 1. 使用一个数组来表时最终结果， 下表 index 表示行，arr[index] 表示列
     * 2.
     * 3. attack[][]  是否可以放置皇后：0表示不可放置，1表示可以放置
     * 4. queen[][]   是否放置了皇后：空格使用 · 表示，有皇后的位置用 Q表示
     * 5. dx表示行，dy表示列，顺序为：上下左右，左上，右上，左下，右下
     *
     * @param arr
     * @return
     */
    public void putQueen(int x, int y, int[][] attack) {

        // 方向数组
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        attack[x][y] = 1; // 皇后位置标记为1


        for (int i = 1; i < attack.length; i++) {
            for (int j = 1; j < 8; j++) {
                int nx = x + i * dx[j];
                int ny = y + i * dy[j];

                if (nx >= 0 && nx < attack.length && ny >= 0 && ny <= attack.length) {
                    attack[nx][ny] = 1;
                }
            }
        }

        System.out.println(attack);


    }
}
