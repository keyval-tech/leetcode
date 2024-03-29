package com.kovizone.leetcode.solution;

import cn.hutool.core.util.ArrayUtil;

/**
 * <a href="https://leetcode.cn/problems/remove-element/?envType=study-plan-v2">27. 移除元素</a>
 * <p>
 * #数组 #双指针 #简单 #面试经典150题
 *
 * @author KV
 * @since 2023/05/08
 */
public class Solution0027E {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == val) {
                nums[l] = nums[r];
                r--;
            } else {
                l++;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 5, 6};
        System.out.println(new Solution0027E().removeElement(nums, 3));
        System.out.println(ArrayUtil.toString(nums));
    }
}
