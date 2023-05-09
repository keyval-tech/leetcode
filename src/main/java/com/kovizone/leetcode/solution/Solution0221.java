package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/maximal-square/">221. 最大正方形</a>
 *
 * @author KV
 * @since 2023/02/03
 */
public class Solution0221 {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, 1);
                    int currentMaxSide = Math.min(rows - i, columns - j);
                    if (currentMaxSide > maxSide) {
                        a:
                        for (int k = 1; k < currentMaxSide; k++) {
                            for (int m = 0; m <= k; m++) {
                                if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                    break a;
                                }
                            }
                            maxSide = Math.max(maxSide, k + 1);
                        }
                    }
                }
            }
        }
        return maxSide * maxSide;
    }
}
