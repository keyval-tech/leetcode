package com.kovizone.leetcode.page00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-ii/">40. 组合总和 II</a>
 *
 * @author KV
 * @see Solution0039
 * @since 2022/10/20
 */
public class Solution0040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        List<List<Integer>> ans = new ArrayList<>();
        sdf(candidates, ans, new ArrayList<>(), 0, target, new boolean[candidates.length]);
        return ans;
    }

    public void sdf(final int[] nums,
                    List<List<Integer>> ans,
                    List<Integer> perm,
                    int idx,
                    final int target,
                    final boolean[] vis) {
        if (target == 0) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            if (vis[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
                continue;
            }
            vis[i] = true;
            perm.add(nums[i]);
            sdf(nums, ans, perm, i + 1, target - nums[i], vis);
            perm.remove(perm.size() - 1);
            vis[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0040().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

}
