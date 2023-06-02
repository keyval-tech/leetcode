package com.kovizone.leetcode.solution;

import cn.hutool.core.util.ArrayUtil;

/**
 * <a href="https://leetcode.cn/problems/rotate-image/">48. 旋转图像</a>
 * <p>
 * #数组 #数学 #矩阵 #中等 #面试经典150题
 *
 * @author KV
 * @since 2023/06/01
 */
public class Solution0048M {

    public void rotate(int[][] matrix) {
        for (int x = 0; x < matrix.length / 2; x++) {
            for (int y = x; y < matrix[0].length - x - 1; y++) {
                int m = y - x;
                int n = matrix[0].length - 1 - y - x;

                exchange(matrix, x, y, x + m, y + n);
                exchange(matrix, x, y, x + m + n, y + n - m);
                exchange(matrix, x, y, x + n, y - m);
            }
        }
    }

    private void exchange(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        };

        new Solution0048M().rotate(matrix);

        for (int[] ints : matrix) {
            System.out.println(ArrayUtil.toString(ints));
        }


        // 40 01 02 03 00
        // 10 11 12 13 14
        // 20 21 22 23 24
        // 30 31 32 33 34
        // 44 41 42 43 04

        // 40 30 20 10 00
        // 41 31 21 11 01
        // 42 32 22 12 02
        // 43 33 23 13 03
        // 44 34 24 14 04

        // 00 -> 04 (+0) (+4) x=0 y=0 length=5 z=4
        // 04 -> 44 (+4) (-0) m=0(y-x) n=4(z-x-y)
        // 44 -> 40 (-0) (-4)
        // 40 -> 00 (-4) (+0)

        // 01 -> 14 (+1) (+3) x=0 y=1 length=5 z=4
        // 14 -> 43 (+3) (-1) m=1(y-x) n=3(z-x-y)
        // 43 -> 30 (-1) (-3)
        // 30 -> 01 (-3) (+1)

        // 11 -> 13 (+0) (+2) x=1 y=1 length=5 z=4
        // 13 -> 33 (+2) (-0) m=0(y-x) n=2(z-x-y)
        // 33 -> 31 (-0) (-2)
        // 31 -> 11 (-2) (+0)

        // 11 -> 13 (+0) (+2) x=1 y=1 length=5 z=4
        // 13 -> 33 (+2) (-0) m=0(y-x) n=2(z-x-y)
        // 33 -> 31 (-0) (-2)
        // 31 -> 11 (-2) (+0)

        // 03 -> 34 (+3) (+1) x=0 y=3 length=5 z=4
        // 34 -> 41 (+1) (-3) m=3(y-x) n=1(z-x-y)
        // 41 -> 10 (-3) (-1)
        // 10 -> 03 (-1) (+3)

        // 03 -> 34 (+3) (+1)
        // 34 -> 41 (+3+1) (-3)
        // 41 -> 10 (-3) (-1)
        // 10 -> 03 (-1) (+3)


        // 00 01 02 03      30 20 10 00
        // 10 11 12 13  --> 31 21 11 01
        // 20 21 22 23      32 22 12 02
        // 30 31 32 33      33 23 13 03

        // 01 -> 13 x=0 y=1 m=1 n=2


        // 00 01 02 03 04 05       50 40 30 20 10 00
        // 10 11 12 13 14 15       51 41 31 21 11 01
        // 20 21 22 23 24 25  -->  52 42 32 22 12 02
        // 30 31 32 33 34 35       53 43 33 23 13 03
        // 40 41 42 43 44 45       54 44 34 24 14 04
        // 50 51 52 53 54 55       55 45 35 25 15 05


    }
}
