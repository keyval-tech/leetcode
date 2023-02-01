package com.kovizone.leetcode.other;

import cn.hutool.json.JSONUtil;

/**
 * 快速排序、快排
 *
 * @author KV
 * @since 2022/08/09
 */
public class QuickSort {

    public static void main(String[] args) {
        Integer[] intArr = new Integer[]{4, 2, 5, 1, 9, 0, 3, 8, 6, 7, 1};
        new QuickSort().sort(intArr);
        System.out.println(JSONUtil.toJsonStr(intArr));
    }

    public <C extends Comparable<C>> void sort(C[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序
     * <p>
     * 操作范围限制：索引下标为low到height的arr
     * <p>
     * 确定key值的索引下标：任取某个索引下标（这里直接用low）
     * <p>
     * 核心原理：让key的左边的所有数小于key，key的右边都大于key，再递归
     *
     * @param arr      数组
     * @param minIndex 最小索引
     * @param maxIndex 最大索引
     * @param <C>      支持比较的对象
     */
    public <C extends Comparable<C>> void sort(C[] arr, int minIndex, int maxIndex) {
        if (arr == null || minIndex >= maxIndex) {
            return;
        }
        int l = minIndex, r = maxIndex;
        final C key = arr[l];
        while (l < r) {
            while (arr[r].compareTo(key) >= 0 && l < r) {
                r--;
            }
            while (arr[l].compareTo(key) <= 0 && l < r) {
                l++;
            }
            if (l != r) {
                C temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        if (l != minIndex) {
            C temp = arr[minIndex];
            arr[minIndex] = arr[l];
            arr[l] = temp;
        }
        sort(arr, minIndex, l - 1);
        sort(arr, l + 1, maxIndex);
    }
}
