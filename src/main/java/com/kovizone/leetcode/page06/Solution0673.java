package com.kovizone.leetcode.page06;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/number-of-longest-increasing-subsequence">673. 最长递增子序列的个数</a>
 * <p>
 * 最长递增子序列算法：{@link com.kovizone.leetcode.page03.Solution0300}
 *
 * @author KV
 * @since 2023/01/30
 */
public class Solution0673 {

    public int findNumberOfLts(int[] nums) {
        // 记录数组到nums[i]为止最长递增子序列长度
        int[] len = new int[nums.length];
        Arrays.fill(len, 1);
        // 记录数组到nums[i]为止，结尾为nums[i]的最长递增子序列长度的个数
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);

        // 记录最长递增子序列长度
        int maxLength = 1;

        for (int r = 0; r < nums.length; r++) {
            for (int l = 0; l < r; l++) {
                if (nums[r] > nums[l]) {
                    if (len[l] + 1 > len[r]) {
                        len[r] = len[l] + 1;
                        count[r] = count[l];
                    } else if (len[l] + 1 == len[r]) {
                        count[r] += count[l];
                    }
                }
            }

            // 记录最长递增子序列长度
            maxLength = Math.max(maxLength, len[r]);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxLength == len[i]) {
                res += count[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // nums    [1]
        // length  [1, 1, 1, 1, 1, 1]
        // count   [1, 1, 1, 1, 1, 1]
        //
        // nums    [1, 3]
        // length  [1, 2, 1, 1, 1, 1]
        // count   [1, 1, 1, 1, 1, 1]
        //
        // nums    [1, 3, 5]
        // length  [1, 2, 3, 1, 1, 1]
        // count   [1, 1, 1, 1, 1, 1]
        //
        // nums    [1, 3, 5, 4]
        // length  [1, 2, 3, 3, 1, 1]
        // count   [1, 1, 1, 1, 1, 1]
        //
        // nums    [1, 3, 5, 4, 8]
        // length  [1, 2, 3, 3, 4, 1]
        // count   [1, 1, 1, 1, 2, 1]
        //
        // nums    [1, 3, 5, 4, 8, 7]
        // length  [1, 2, 3, 3, 4, 4]
        // count   [1, 1, 1, 1, 2, 2]
        //
        int[] intArr = new int[]{1, 3, 5, 4, 8, 7};
        System.out.println(new Solution0673().findNumberOfLts(intArr));
    }

}