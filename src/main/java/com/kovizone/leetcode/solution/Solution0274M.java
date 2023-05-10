package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/h-index/?envType=study-plan-v2">274. H 指数</a>
 * <p>
 * 难度：中等
 * <p>
 * #数组 #计数排序 #排序
 *
 * @author KV
 * @since 2023/05/10
 */
public class Solution0274M {
    public int hIndex(int[] citations) {
        int n = citations.length;

        int[] p = new int[n + 1];
        for (int citation : citations) {
            p[Math.min(citation, n)]++;
        }

        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += p[i];
            System.out.println("i: " + i + ", sum: " + sum);
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new Solution0274M().hIndex(new int[]{1});
    }
}
