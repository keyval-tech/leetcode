package com.kovizone.leetcode.solution;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/subsets-ii/">90. 子集 II</a>
 *
 * @author KV
 * @see Solution0078
 * @since 2022/08/24
 */
public class Solution0090 {

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        // TODO 待改进
        Arrays.sort(nums);
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

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            subsetsWithDup(ans, nums, i, new ArrayList<>());
        }
        return new ArrayList<>(ans);
    }

    public void subsetsWithDup(Set<List<Integer>> ans, final int[] nums, int p, List<Integer> prefixIndex) {
        List<Integer> list = new ArrayList<>();
        for (Integer index : prefixIndex) {
            list.add(nums[index]);
        }
        list.add(nums[p]);
        ans.add(list);

        List<Integer> nextPrefixIndex = new ArrayList<>(prefixIndex);
        nextPrefixIndex.add(p);
        if (nums.length - p > 1) {
            for (int i = p + 1; i < nums.length; i++) {
                subsetsWithDup(ans, nums, i, nextPrefixIndex);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0090().subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }
}
