package com.kovizone.leetcode.page90;

import cn.hutool.json.JSONUtil;

/**
 * 快速排序
 *
 * @author KV
 * @since 2022/08/09
 */
public class Solution9001QuickSort {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{4, 2, 5, 1, 9, 0, 3, 8, 6, 7};
        new Solution9001QuickSort().sort(ints);
        System.out.println(JSONUtil.toJsonStr(ints));
    }

    public <C extends Comparable<C>> void sort(C[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public <C extends Comparable<C>> void sort(C[] arr, int low, int height) {
        if (arr == null || low >= height) {
            return;
        }
        int l = low, h = height;
        C p = arr[l];
        while (l < h) {
            while (arr[h].compareTo(p) >= 0 && l < h) {
                h--;
            }
            while (arr[l].compareTo(p) <= 0 && l < h) {
                l++;
            }

            if (l != h) {
                C temp = arr[l];
                arr[l] = arr[h];
                arr[h] = temp;
            }
        }
        if (l != low) {
            C temp = arr[low];
            arr[low] = arr[l];
            arr[l] = temp;
        }
        sort(arr, low, l - 1);
        sort(arr, l + 1, height);
    }
}
