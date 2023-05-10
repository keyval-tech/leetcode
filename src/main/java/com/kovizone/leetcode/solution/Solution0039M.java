package com.kovizone.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href=“https://leetcode.cn/problems/combination-sum”>39. 组合总和</a>
 * <p>
 * #数组 #回溯
 *
 * @author KV
 * @since 2022/10/20
 */
public class Solution0039M {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        sdf(candidates, ans, new ArrayList<>(), 0, target);
        return ans;
    }

    public void sdf(final int[] nums,
                    List<List<Integer>> ans,
                    List<Integer> perm,
                    int idx,
                    final int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            perm.add(nums[i]);
            sdf(nums, ans, perm, i, target - nums[i]);
            perm.remove(perm.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0039M().combinationSum(new int[]{2, 3, 6, 4, 7}, 7));
    }

}