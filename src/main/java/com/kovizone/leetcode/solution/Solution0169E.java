package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/majority-element/">169. 多数元素</a>
 * <p>
 * #数组 #哈希表 #分治 #计数 #排序 #简单 #面试经典150题
 *
 * @author KV
 * @since 2023/05/09
 */
public class Solution0169E {
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
