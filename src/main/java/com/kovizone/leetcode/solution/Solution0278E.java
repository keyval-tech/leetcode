package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/first-bad-version/">278. 第一个错误的版本</a>
 * <p>
 * #二分查找 #交互 #简单
 *
 * @author KV
 * @since 2022/07/05
 */
public class Solution0278E {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
