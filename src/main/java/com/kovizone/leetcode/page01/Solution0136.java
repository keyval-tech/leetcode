package com.kovizone.leetcode.page01;

/**
 * <a href="https://leetcode.cn/problems/single-number/">136. 只出现一次的数字</a>
 *
 * @author KV
 * @since 2022/08/05
 */
public class Solution0136 {

    public int singleNumber(int[] nums) {
        int s = 0;
        for (int num : nums) {
            s ^= num;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0136().singleNumber(new int[]{2, 2, 1, 3, 3}));
    }
}
