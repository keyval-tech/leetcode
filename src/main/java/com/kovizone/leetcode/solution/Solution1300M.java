package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/sum-of-mutated-array-closest-to-target/">1300. 转变数组后最接近目标值的数组和</a>
 * <p>
 * #数组 #二分查找 #排序 #中等
 *
 * @author KV
 */
public class Solution1300M {

    public int findBestValue(int[] arr, int target) {
        if (target == 0) {
            return 0;
        }
        int minDif = target;
        int value = 0;

        for (int i = 1; i <= target; i++) {
            int sum = sum(arr, i);
            int dif = Math.abs(target - sum(arr, i));
            System.out.println("i: " + i + ", dif: " + dif + ", sum: " + sum + ", minDif: " + minDif);
            if (dif < minDif) {
                minDif = dif;
                value = i;
            } else {
                break;
            }
        }
        return value;
    }

    private int sum(int[] arr, int min) {
        int result = 0;
        for (int i : arr) {
            result += (Math.min(i, min));
        }
        return result;
    }
}
