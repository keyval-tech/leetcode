package com.kovizone.leetcode.solution;

import cn.hutool.core.thread.ThreadUtil;

/**
 * <a href="https://leetcode.cn/problems/peak-index-in-a-mountain-array/">852. 山脉数组的峰顶索引</a>
 * <p>
 * #数组 #二分查找 #中等
 *
 * @author KV
 * @since 2022/08/05
 */
public class Solution0852M {
    public int peakIndexInMountainArray(int[] arr) {
        return peakIndexInMountainArray(arr, 1, arr.length - 2);
    }


    public int peakIndexInMountainArray(int[] arr, int l, int r) {
        ThreadUtil.sleep(1000);
        int c = (r - l) / 2 + l;
        System.out.printf("l: %d, r: %d, c: %d   %n", l, r, c);
        if (arr[c] < arr[c - 1]) {
            return peakIndexInMountainArray(arr, l, c - 1);
        }
        if (arr[c] < arr[c + 1]) {
            return peakIndexInMountainArray(arr, c + 1, r);
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0852M().peakIndexInMountainArray(new int[]{1, 2, 1, 0}));
    }
}