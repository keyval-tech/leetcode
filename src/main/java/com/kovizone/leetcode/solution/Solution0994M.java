package com.kovizone.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/rotting-oranges/">994. 腐烂的橘子</a>
 * <p>
 * #广度优先搜索 #数组 #矩阵 #中等
 *
 * @author KV
 * @since 2022/07/13
 */
public class Solution0994M {

    static int[] dr = {0, 1, -1, 0};
    static int[] dc = {1, 0, 0, -1};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> rottenQueue = new LinkedList<>();

        // 记录初始新鲜水果数量
        int fresh = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                } else if (grid[r][c] == 2) {
                    rottenQueue.add(new int[]{r, c});
                }
            }
        }

        int time = 0;
        while (fresh > 0 && !rottenQueue.isEmpty()) {
            time++;
            int size = rottenQueue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = rottenQueue.poll();
                int r = rotten[0];
                int c = rotten[1];
                for (int di = 0; di < 4; di++) {
                    int r2 = r + dr[di];
                    int c2 = c + dc[di];
                    if (r2 >= 0 && r2 < m && c2 >= 0 && c2 < n && grid[r2][c2] == 1) {
                        fresh--;
                        grid[r2][c2] = 2;
                        rottenQueue.add(new int[]{r2, c2});
                    }
                }
            }
        }

        if (fresh > 0) {
            return -1;
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0994M().orangesRotting(new int[][]{
                new int[]{2, 1, 1},
                new int[]{1, 1, 0},
                new int[]{0, 1, 1},
                //new int[]{2, 1},
                /*new int[]{2, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                new int[]{1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                new int[]{1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                new int[]{1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                new int[]{1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                new int[]{1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
                new int[]{1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},*/
        }));
    }


}
