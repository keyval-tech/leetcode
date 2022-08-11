package com.kovizone.leetcode.page09;

import cn.hutool.json.JSONUtil;

/**
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/">977. 有序数组的平方</a>
 *
 * @author KV
 * @since 2022/07/05
 */
public class Solution0977SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = nums.length - 1;
        int[] result = new int[nums.length];

        int lq = nums[l] * nums[l];
        int rq = nums[r] * nums[r];

        while (l <= r) {
            if (lq >= rq) {
                result[i--] = lq;
                l++;
                lq = nums[l] * nums[l];
            } else {
                result[i--] = rq;
                r--;
                rq = nums[r] * nums[r];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-7, -3, 2, 3, 11};
        System.out.println(JSONUtil.toJsonStr(nums));
        System.out.println(JSONUtil.toJsonStr(new Solution0977SquaresSortedArray().sortedSquares(nums)));
    }
}
