package com.kovizone.leetcode.solution;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/set-matrix-zeroes/">73. 矩阵置零</a>
 * <p>
 * #数组 #哈希表 #矩阵 #中等 #面试经典150题
 *
 * @author KV
 * @since 2023/06/02
 */
public class Solution0073M {
    public void setZeroes(int[][] matrix) {

        boolean firstRowSetZeroes = false;
        boolean firstCellSetZeroes = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowSetZeroes = true;
                break;
            }
        }

        for (int[] line : matrix) {
            if (line[0] == 0) {
                firstCellSetZeroes = true;
                break;
            }
        }

        for (int x = 1; x < matrix.length; x++) {
            for (int y = 1; y < matrix[x].length; y++) {
                if (matrix[x][y] == 0) {
                    matrix[x][0] = 0;
                    matrix[0][y] = 0;
                }
            }
        }

        for (int x = 1; x < matrix.length; x++) {
            for (int y = 1; y < matrix[x].length; y++) {
                if (matrix[x][0] == 0 || matrix[0][y] == 0) {
                    matrix[x][y] = 0;
                }
            }
        }

        if (firstRowSetZeroes) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstCellSetZeroes) {
            for (int[] line : matrix) {
                line[0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 0, 2, 1},
                new int[]{3, 4, 1, 2},
                new int[]{1, 3, 1, 0},
        };
        for (int[] ints : matrix) {
            System.out.println(ArrayUtil.toString(ints));
        }
        System.out.println();

        new Solution0073M().setZeroes(matrix);

        for (int[] ints : matrix) {
            System.out.println(ArrayUtil.toString(ints));
        }
    }
}
