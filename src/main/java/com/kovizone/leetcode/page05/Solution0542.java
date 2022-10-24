package com.kovizone.leetcode.page05;

import cn.hutool.json.JSONUtil;

/**
 * <a href="https://leetcode.cn/problems/01-matrix/">542. 01 矩阵</a>
 *
 * @author KV
 * @since 2022/07/13
 */
public class Solution0542 {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 初始化
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = matrix[i][j] * (m + n);
            }
        }

        // 遍历所有元素，对比其左和其上
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                }
                if (j > 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
        // 遍历所有元素，对比其右和其下
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {

        int[][] ints = new Solution0542().updateMatrix(new int[][]{
                // [[0,1,0,1,1],[1,1,0,0,1],[0,0,0,1,0],[1,0,1,1,1],[1,0,0,0,1]]
                new int[]{1, 1, 0, 1, 1},
                new int[]{1, 1, 0, 0, 1},
                new int[]{0, 0, 0, 1, 0},
                new int[]{1, 0, 1, 1, 1},
                new int[]{1, 0, 0, 1, 1},
        });

        for (int[] anInt : ints) {
            System.out.println(JSONUtil.toJsonStr(anInt));
        }
    }


}
