package com.kovizone.leetcode.page05;

/**
 * <a href="https://leetcode.cn/problems/number-of-provinces/">547. 省份数量</a>
 *
 * @author KV
 * @since 2022/08/15
 */
public class Solution0547 {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        for (int r = 0; r < isConnected.length; r++) {
            if (isConnected[r][r] == 1) {
                ans++;
                clear(isConnected, r);
            }
        }
        return ans;
    }

    private void clear(int[][] isConnected, int r) {
        if (isConnected[r][r] == 0) {
            return;
        }
        for (int i = 0; i < isConnected[r].length; i++) {
            if (isConnected[r][i] == 1) {
                isConnected[r][i] = 0;
                clear(isConnected, i);
            }
        }
    }

    // 1 0 1 1 0
    // 0 1 0 0 0
    // 1 0 1 0 0
    // 1 0 0 1 0
    // 0 1 0 0 0
}
