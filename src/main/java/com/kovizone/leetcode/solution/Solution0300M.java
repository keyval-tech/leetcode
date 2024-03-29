package com.kovizone.leetcode.solution;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence">300. 最长递增子序列</a>
 * <p>
 * 进阶：{@link Solution0673M}
 *
 * #数组 #二分查找 #动态规划
 *
 * @author KV
 * @since 2022/12/29
 */
public class Solution0300M {
    public int lengthOfLts(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
            System.out.println();
            System.out.println(temp);
            System.out.println(ArrayUtil.toString(tails));
            int l = 0, r = res;
            // 检查tail中是第一个大于num的数，如果存在，替换它下标前一位的值，否则加到tail有效值的后一位
            while (l < r) {
                int m = (l + r) / 2;
                if (tails[m] < num) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            tails[l] = num;
            if (res == r) {
                res++;
            }
            System.out.println(ArrayUtil.toString(tails));
        }
        return res;
    }

    public int lengthOfLts2(int[] nums) {

        System.out.println("nums: " + ArrayUtil.toString(nums));

        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            System.out.println();
            System.out.println("nums[" + i + "]: " + nums[i] + ", d[len]: " + d[len] + ", len: " + len);
            System.out.println("> d[" + len + "](" + d[len] + "): " + (nums[i] > d[len]) + ", \td: " + ArrayUtil.toString(d));
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    System.out.print("> d[" + mid + "](" + d[mid] + "): " + (d[mid] < nums[i]) + ", \t[" + l + ", " + mid + ", " + r + "]");
                    if (nums[i] > d[mid]) {
                        pos = mid;
                        l = mid + 1;
                        System.out.print(", pos: " + pos);
                    } else {
                        r = mid - 1;
                    }
                    System.out.println();
                }
                d[pos + 1] = nums[i];
            }
            System.out.println("\t\t\t\t\td: " + ArrayUtil.toString(d));
        }
        System.out.println(ArrayUtil.toString(d));
        System.out.println();
        return len;
    }

    public int lengthOfLts1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    System.out.println("nums[" + j + "]: " + nums[j] + ", nums[" + i + "]: " + nums[i] + ", dp: " + ArrayUtil.toString(dp));
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println();
        System.out.println(ArrayUtil.toString(dp));

        return max + 1;
    }

    public static void main(String[] args) {
        int[] intArr = new int[]{6, 4, 7, 0, 15, 1, 19, 3, 12, 9, 19, 9, 11, 11, 14, 16, 4, 8, 6, 18,17};
        System.out.println(new Solution0300M().lengthOfLts(intArr));
    }

    public static void main1(String[] args) {
        for (int i = 0; i < 20; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(RandomUtil.randomInt(0, 20));
        }
    }
}
