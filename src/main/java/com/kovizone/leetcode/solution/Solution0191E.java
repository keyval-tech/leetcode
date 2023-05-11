package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/number-of-1-bits/">191. 位1的个数</a>
 * <p>
 * #位运算 #分治 #简单
 *
 * @author KV
 * @since 2022/08/05
 */
public class Solution0191E {

    public int hammingWeight(int n) {
        int hammingWeight = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                hammingWeight++;
            }
        }
        return hammingWeight;
    }
}