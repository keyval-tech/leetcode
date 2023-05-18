package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/roman-to-integer/?envType=study-plan-v2&id=top-interview-150">13. 罗马数字转整数</a>
 * <p>
 * #哈希表 #数学 #字符串 #简单
 *
 * @author KV
 * @since 2023/05/18
 */
public class Solution0013E {

    public int romanToInt(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        char last = ' ';
        for (char c : chars) {
            res += sdf(c);
            if (c == 'V' || c == 'X') {
                if (last == 'I') {
                    res -= sdf(last) * 2;
                }
            }
            if (c == 'L' || c == 'C') {
                if (last == 'X') {
                    res -= sdf(last) * 2;
                }
            }
            if (c == 'D' || c == 'M') {
                if (last == 'C') {
                    res -= sdf(last) * 2;
                }
            }
            last = c;
        }
        return res;
    }

    private int sdf(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
