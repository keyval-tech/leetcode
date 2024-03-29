package com.kovizone.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">1. 两数之和</a>
 * <p>
 * #数组 #哈希表 #简单
 *
 * @author KV
 * @since 2022/07/04
 */
public class Solution0001E {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if (j != null) {
                return new int[]{i, j};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
