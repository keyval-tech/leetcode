package com.kovizone.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/spiral-matrix/">54. 螺旋矩阵</a>
 * <p>
 * #数组 #矩阵 #模拟 #中等 #面试经典150题
 *
 * @author KV
 * @since 2023/06/01
 */
public class Solution0054M {

    int[] xOffset = new int[]{0, +1, 0, -1};
    int[] yOffset = new int[]{+1, 0, -1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        next(res, matrix, 0, 0, 0);
        return res;
    }

    private void next(List<Integer> res, int[][] matrix, int x, int y, int offset) {
        if (x < 0 || x >= matrix.length) {
            return;
        }
        if (y < 0 || y >= matrix[0].length) {
            return;
        }
        if (matrix[x][y] == Integer.MAX_VALUE) {
            return;
        }
        res.add(matrix[x][y]);
        matrix[x][y] = Integer.MAX_VALUE;
        offset = offset % 4;
        next(res, matrix, x + xOffset[offset], y + yOffset[offset], offset);
        offset = (offset + 1) % 4;
        next(res, matrix, x + xOffset[offset], y + yOffset[offset], offset);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0054M().spiralOrder(
                new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{4, 5, 6},
                        new int[]{7, 8, 9},
                }
        ));
        System.out.println(new Solution0054M().spiralOrder(
                new int[][]{
                        new int[]{1, 2, 3, 4},
                        new int[]{5, 6, 7, 8},
                        new int[]{9, 10, 11, 12},
                        new int[]{13, 14, 15, 16},
                }
        ));
    }
}
