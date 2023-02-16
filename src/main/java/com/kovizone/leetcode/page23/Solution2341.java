package com.kovizone.leetcode.page23;

import cn.hutool.core.util.ArrayUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-pairs-in-array/">2341. 数组能形成多少数对</a>
 *
 * @author KV
 * @since 2023/02/16
 */
public class Solution2341 {
    public int[] numberOfPairs(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.remove(num)) {
                set.add(num);
            }
        }
        return new int[]{(nums.length - set.size()) / 2, set.size()};
    }

    public static void main(String[] args) {
        System.out.println(ArrayUtil.toString(new Solution2341().numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2})));
    }
}
