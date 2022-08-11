package com.kovizone.leetcode.page13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/the-k-weakest-rows-in-a-matrix/">1337. 矩阵中战斗力最弱的 K 行</a>
 *
 * @author KV
 * @since 2022/08/09
 */
public class Solution1337TheKWeakestRowsMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        // TODO 待优化
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int[] nums = mat[i];
            int s = sdf(nums);
            list.add(new int[]{s, i});
        }

        list.sort(Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[1];
        }

        return result;
    }

    public int sdf(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int c = (l + r) >> 1;
            if (nums[c] == 0) {
                r = c - 1;
            } else {
                l = c + 1;
            }
        }
        return r + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1337TheKWeakestRowsMatrix().sdf(new int[]{1, 1, 1, 1}));
    }
}
