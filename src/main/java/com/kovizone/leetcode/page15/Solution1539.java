package com.kovizone.leetcode.page15;

/**
 * <a href="https://leetcode.cn/problems/kth-missing-positive-number/">1539. 第 k 个缺失的正整数</a>
 *
 * @author KV
 * @since 2022/08/08
 */
public class Solution1539 {
    public int findKthPositive2(int[] arr, int k) {
        int s = k;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("i: %d, arr[i]: %d, s: %d%n", i, arr[i], s);
            if (arr[i] < s) {
                s++;
            }
        }
        return s;
    }

    public int findKthPositive1(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int c = (r - l) / 2 + l;
            System.out.printf("l: %d, c: %d, r: %d%n", l, c, r);
            if (c == arr.length || arr[c] - c > k) {
                r = c;
            } else {
                l = c + 1;
            }
        }
        return k - (arr[l - 1] - l) + arr[l - 1];
    }

    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int c = (r - l) / 2 + l;
            if (arr[c] - c - 1 < k) {
                l = c + 1;
            } else {
                r = c - 1;
            }
        }
        return k + l;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1539().findKthPositive(new int[]{1, 3}, 1));
        System.out.println();
        System.out.println(new Solution1539().findKthPositive(new int[]{1, 2, 3, 4}, 2));
        System.out.println();
        System.out.println(new Solution1539().findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        // 00 01 02 03 04
        // 02 03 04 07 11
        // 01 01 01 03 06
    }
}
