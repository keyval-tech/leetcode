package com.kovizone.leetcode.page13;

/**
 * <a href="https://leetcode.cn/problems/count-negative-numbers-in-a-sorted-matrix/">1351. 统计有序矩阵中的负数</a>
 *
 * @author KV
 * @since 2022/08/09
 */
public class Solution1351CountNegativeNumbersSortedMatrix {
    public int countNegatives(int[][] grid) {
        int s = 0;
        int gridLength = grid.length;
        int numsLength = grid[0].length;
        for (int i = 0; i < gridLength; i++) {
            int count = countNegatives(grid[i], numsLength);
            if (count != 0) {
                numsLength -= count;
                s += (count * (gridLength - i));
            }
            if (numsLength == 0) {
                break;
            }
        }

        return s;
    }

    public int countNegatives(int[] nums, int size) {
        int s = size;
        int l = 0;
        int r = size - 1;
        while (l <= r) {
            int c = (l + r) >> 1;
            if (nums[c] < 0) {
                s = c;
                r = c - 1;
            } else {
                l = c + 1;
            }
        }
        return size - s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1351CountNegativeNumbersSortedMatrix().countNegatives(new int[][]{
                new int[]{+4, +3, +2, -1},
                new int[]{+3, +2, +1, -1},
                new int[]{+1, +1, -1, -2},
                new int[]{-1, -1, -2, -3},
        }));
        System.out.println();
        System.out.println(new Solution1351CountNegativeNumbersSortedMatrix().countNegatives(new int[][]{
                new int[]{+5, +1, +0},
                new int[]{-5, -5, -5},
        }));
    }
}
