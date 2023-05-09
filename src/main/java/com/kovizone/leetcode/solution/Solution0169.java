package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/majority-element/">169. 多数元素</a>
 *
 * @author KV
 * @since 2023/05/09
 */
public class Solution0169 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int p = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                p = nums[i];
            }
            count += nums[i] == p ? 1 : -1;
        }
        return p;
    }
}
