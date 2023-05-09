package com.kovizone.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/climbing-stairs/">70. 爬楼梯</a>
 *
 * @author KV
 * @since 2022/08/02
 */
public class Solution0070 {

    private final static Map<Integer, Integer> CACHE = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        if (CACHE.containsKey(n)) {
            return CACHE.get(n);
        }
        int s = climbStairs(n - 1) + climbStairs(n - 2);
        CACHE.put(n, s);
        return s;
    }
}
