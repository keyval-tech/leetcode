package com.kovizone.leetcode.page10;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/shortest-path-in-binary-matrix/">1091. 二进制矩阵中的最短路径</a>
 *
 * @author KV
 * @since 2022/08/19
 */
public class Solution1091ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int length = grid.length;
        if (grid[0][0] == 1 || grid[length - 1][length - 1] == 1) {
            return -1;
        }
        if (length == 1) {
            return 1;
        }
        int[] offsetR = {+1, +1, +0, +1, -1, +0, -1, -1};
        int[] offsetC = {+1, +0, +1, -1, +1, -1, +0, -1};

        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            ans++;
            int queueSize = queue.size();
            System.out.println();
            System.out.println("size: " + queueSize + ", queue: " + JSONUtil.toJsonStr(queue));
            for (int i = 0; i < queueSize; i++) {
                int[] s = queue.poll();
                System.out.println("queue.poll(): " + Arrays.toString(s));
                if (s != null) {
                    int r = s[0], c = s[1];
                    if (grid[r][c] == 0) {
                        grid[r][c] = 2;
                        for (int j = 0; j < 8; j++) {
                            int nextR = r + offsetR[j];
                            int nextC = c + offsetC[j];
                            if (nextR == length - 1 && nextC == length - 1) {
                                return ans + 1;
                            }
                            if (nextR >= 0 && nextC >= 0 && nextR < length && nextC < length && grid[nextR][nextC] == 0) {
                                queue.add(new int[]{nextR, nextC});
                                System.out.println("queue.add(new int[]{" + nextR + ", " + nextC + "})");
                            }
                        }
                        System.out.println();
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1091ShortestPathBinaryMatrix().shortestPathBinaryMatrix(
                new int[][]{
                        {0, 0, 0, 0, 1},
                        {1, 1, 1, 0, 0},
                        {1, 1, 0, 1, 1},
                        {1, 0, 1, 1, 1},
                        {1, 0, 0, 0, 0},
                }
        ));
    }


    // 0 1 1 1 0
    // 1 0 1 0 0
    // 1 0 1 1 0
    // 0 1 1 1 1
    // 0 0 0 0 0
}
