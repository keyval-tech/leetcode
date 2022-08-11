package com.kovizone.leetcode.page03;

/**
 * <a href="https://leetcode.cn/problems/range-sum-query-2d-immutable/">304. 二维区域和检索 - 矩阵不可变</a>
 *
 * @author KV
 */
public class Solution0304RangeSumQuery2dImmutable {
    static class NumMatrix {

        int[][] sums;

        public NumMatrix(int[][] matrix) {
            this.sums = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
        }
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(
                new int[][]{
                        new int[]{3, 0, 1, 4, 2},
                        new int[]{5, 6, 3, 2, 1},
                        new int[]{1, 2, 0, 1, 5},
                        new int[]{4, 1, 0, 1, 7},
                        new int[]{1, 0, 3, 0, 5},
                }
        );


        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}
