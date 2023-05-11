package com.kovizone.leetcode.solution;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/interval-list-intersections/">986. 区间列表的交集</a>
 *
 * #数组 #双指针 #中等
 *
 * @author KV
 * @since 2022/08/10
 */
public class Solution0986M {

    public static void main(String[] args) {
        System.out.println(JSONUtil.toJsonStr(new Solution0986M().intervalIntersection(
                new int[][]{
                        new int[]{4, 6},
                        new int[]{7, 8},
                        new int[]{10, 17}
                },
                new int[][]{
                        new int[]{5, 10}
                }
        )));
    }

    public int[][] intervalIntersection(int[][] l1, int[][] l2) {
        int[][] ans = new int[l1.length + l2.length + 2][2];
        int ansI = 0, p1 = 0, p2 = 0;
        while (p1 < l1.length && p2 < l2.length) {
            int[] n1 = l1[p1];
            int[] n2 = l2[p2];

            if (n1[1] >= n2[0] && n2[1] >= n1[0]) {
                ans[ansI++] = new int[]{Math.max(n1[0], n2[0]), Math.min(n1[1], n2[1])};
            }

            if (n1[1] <= n2[1]) {
                p1++;
            }

            if (n2[1] <= n1[1]) {
                p2++;
            }
        }
        return Arrays.copyOf(ans, ansI);
    }
}
