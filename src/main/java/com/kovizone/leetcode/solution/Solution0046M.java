package com.kovizone.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/">46. 全排列</a>
 * <p>
 * #数组 #回溯
 *
 * @author KV
 * @since 2022/07/29
 */
public class Solution0046M {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> nodeList = new ArrayList<>();
        permute(nodeList, new ArrayList<>(), nums);
        return nodeList;
    }

    public void permute(List<List<Integer>> nodeList, List<Integer> prefix, final int[] nums) {
        if (nums.length == prefix.size()) {
            nodeList.add(prefix);
        } else {
            for (int num : nums) {
                if (!prefix.contains(num)) {
                    List<Integer> newPrefix = new ArrayList<>(prefix);
                    newPrefix.add(num);
                    permute(nodeList, newPrefix, nums);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution0046M().permute(new int[]{1, 2, 3, 4});
        for (List<Integer> integerList : permute) {
            System.out.println(integerList);
        }
    }
}