package com.kovizone.leetcode.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/happy-number/">202. 快乐数</a>
 * <p>
 * #哈希表 #数学 #双指针 #简单
 *
 * @author KV
 * @since 2023/02/07
 */
public class Solution0202E {

    private final static Set<Integer> CYCLE = new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    public static int next(int n) {
        int s = 0;
        while (n > 0) {
            int x = n % 10;
            s += x * x;
            n /= 10;
        }
        return s;
    }

    public boolean isHappy(int n) {
        int m = n;
        while (m != 1 && !CYCLE.contains(m)) {
            m = next(m);
        }
        if (m != 1) {
            CYCLE.add(n);
        }
        return m == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0202E().isHappy(22));
    }
}
