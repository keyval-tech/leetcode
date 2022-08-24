package com.kovizone.leetcode.page00;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets/">78. 子集</a>
 *
 * @author KV
 * @since 2022/08/24
 */
public class Solution0078Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            subsets(ans, nums, i, new ArrayList<>());
        }
        return ans;
    }

    public void subsets(List<List<Integer>> ans, final int[] nums, int p, List<Integer> prefix) {
        List<Integer> list = new ArrayList<>(prefix);
        list.add(nums[p]);
        ans.add(list);
        if (nums.length - p > 1) {
            for (int i = p + 1; i < nums.length; i++) {
                subsets(ans, nums, i, list);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0078Subsets().subsets(new int[]{1, 2, 3, 4}));
    }

    // 1
    // 1 2
    // 1 2 3
    // 1 2 4
    // 1 3
    // 1 3 4
    // 1 4
    // 2
    // 2 3
    // 2 3 4
    // 2 4
    // 3
    // 3 4
    // 4
}
