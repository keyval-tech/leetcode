package com.kovizone.leetcode;

/**
 * Solution0278FirstBadVersion
 *
 * @author KV
 * @since 2022/07/05
 */
public class Solution0278FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (isBadVersion(m)) {
                r = m;
            }else{
                l = m + 1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
