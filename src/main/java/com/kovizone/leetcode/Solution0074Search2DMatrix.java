package com.kovizone.leetcode;

/**
 * <a href="https://leetcode.cn/problems/search-a-2d-matrix/">74. 搜索二维矩阵</a>
 *
 * @author KV
 * @since 2022/08/09
 */
public class Solution0074Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int matrixLength = matrix.length;
        int numsLength = matrix[0].length;
        int l = 0;
        int r = matrixLength * numsLength - 1;

        while (l <= r) {
            int c = (l + r) >> 1;
            int v = matrix[c / numsLength][c % numsLength];
            if (v == target) {
                return true;
            }
            if (v > target) {
                r = c - 1;
            } else {
                l = c + 1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0074Search2DMatrix().searchMatrix(new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 60}
        }, 3));
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;

        int numsLength = matrix[0].length;

        while (l <= r) {
            int c = (l + r) >> 1;
            int[] nums = matrix[c];
            if (nums[0] > target) {
                r = c - 1;
            } else if (nums[numsLength - 1] < target) {
                l = c + 1;
            } else {
                return searchNums(matrix[c], target);
            }
        }

        return false;
    }

    public boolean searchNums(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int c = (l + r) >> 1;
            if (nums[c] > target) {
                r = c - 1;
            } else if (nums[c] < target) {
                l = c + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
