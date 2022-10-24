package com.kovizone.leetcode.page13;

/**
 * <a href="https://leetcode.cn/problems/find-the-distance-value-between-two-arrays/">1385. 两个数组间的距离值</a>
 *
 * @author KV
 * @since 2022/08/05
 */
public class Solution1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result = arr1.length;
        a:
        for (int i : arr1) {
            System.out.println();
            for (int j : arr2) {
                System.out.printf("i: \t%d, j: \t%d, i-j: %d, abs: \t%d%n", i, j, i - j, Math.abs(i - j));
                if (Math.abs(i - j) <= d) {
                    result--;
                    continue a;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1385().findTheDistanceValue(
                new int[]{1, 4, 2, 3},
                new int[]{-4, -3, 6, 10, 20, 30},
                3
        ));
    }
}
