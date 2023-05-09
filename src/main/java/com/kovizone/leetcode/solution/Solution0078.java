package com.kovizone.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets/">78. 子集</a>
 *
 * @author KV
 * @since 2022/08/24
 */
public class Solution0078 {

    public static void main(String[] args) {
        System.out.println(new Solution0078().subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;
        System.out.println("n: " + n);
        for (int mask = 0; mask < (1 << n); ++mask) {
            System.out.println();
            System.out.println("mask: " + mask);
            t.clear();
            for (int i = 0; i < n; ++i) {
                System.out.println("i: " + i + ", 1 << " + i + " = " + (1 << i));
                System.out.println("(mask & (1 << " + i + ")): " + (mask & (1 << i)));
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            System.out.println("answer: " + t);
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }

    public List<List<Integer>> subsets2(int[] nums) {
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
