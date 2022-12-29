package com.kovizone.leetcode.page01;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/word-break/?envType=study-plan">139. 单词拆分</a>
 *
 * @author KV
 * @since 2022/12/28
 */
public class Solution0139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                for (int j = i + 1; j <= n; j++) {
                    if (wordDictSet.contains(s.substring(i, j))) {
                        dp[j] = true;
                    }
                }
            }
        }

        return dp[n];
    }
}
