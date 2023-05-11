package com.kovizone.leetcode.solution;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/3sum/">15. 三数之和</a>
 * <p>
 * #数组 #双指针 #排序 #中等
 *
 * @author KV
 * @since 2022/08/10
 */
public class Solution0015M {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        System.out.println(JSONUtil.toJsonStr(nums));
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                int left = nums[l];
                int right = nums[r];
                int s = left + right;
                if (s == target) {
                    result.add(Arrays.asList(nums[i], left, right));
                }
                if (s <= target) {
                    while (nums[l] == left && l < r) {
                        l++;
                    }
                }
                if (s >= target) {
                    while (nums[r] == right && l < r) {
                        r--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0015M().threeSum(new int[]{1, 0, 1, 2, -1, -1, -4, -2, -3, 3, 0, 4}));
    }
}
