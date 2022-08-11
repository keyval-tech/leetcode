package com.kovizone.leetcode.page02;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/power-of-two/">231. 2 的幂</a>
 *
 * @author KV
 * @since 2022/08/05
 */
public class Solution0231PowerTwo {

    private static final Set<Integer> SET = new HashSet<>();

    static {
        int i = 1;
        while (i > 0) {
            SET.add(i);
            i <<= 1;
        }
    }

    public boolean isPowerOfTwo(int n) {
        return SET.contains(n);
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        for (int i = 2; i <= 1000; i++) {
            String binary = Integer.toString(i, 2);
            int s = Integer.parseInt(binary);
            System.out.print(String.format("% 5d", i) + ":\t" + String.format("% 10d", s) + ":::" + "1".equals(binary.replace("0", "")));
            for (int j = 0; j < i; j++) {
                if (i == Math.pow(2, j)) {
                    System.out.print(":power");
                    break;
                }
            }
            System.out.println();
        }
    }
}
