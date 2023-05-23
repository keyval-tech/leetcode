package com.kovizone.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/zigzag-conversion/">6. N 字形变换</a>
 * <p>
 * #字符串 #中等 #面试经典150题
 *
 * @author KV
 * @since 2023/05/23
 */
public class Solution0006M {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int t = numRows * 2 - 2;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows && i < n; i++) {
            res.append(chars[i]);
            int p = 1;
            while (true) {
                if (i > 0 && i < numRows - 1) {
                    int j = p * t - i;
                    if (j >= n) {
                        break;
                    }
                    res.append(chars[j]);
                }
                int j = p * t + i;
                if (j >= n) {
                    break;
                }
                res.append(chars[j]);
                p++;
            }
        }
        return res.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        Map<Integer, StringBuilder> strMap = new HashMap<>();
        int flag = -1;
        int numRow = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            strMap.computeIfAbsent(numRow, k -> new StringBuilder()).append(c);
            if (numRow == 0 || numRow == numRows - 1) {
                flag *= -1;
            }
            numRow += flag;
        }

        strMap.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        StringBuilder res = strMap.get(0);
        for (int i = 1; i < numRows; i++) {
            StringBuilder node = strMap.get(i);
            if (node == null) {
                break;
            }
            res.append(node);
        }
        return res.toString();
    }


    /**
     * ABCDEFGHIJKLMNOPQRSTUVWXYZ
     * <p>
     * 0           1t+0           2t+0           3t+0
     * 1      1t-1 1t+1      2t-1 2t+1      3t-1 3t+1
     * 2 1t-2      1t+2 2t-2      2t+2 3t-2      3t+2
     * 3           1t+3           2t+3           3t+3
     */
    public static void main(String[] args) {
        System.out.println(new Solution0006M().convert("PAYPALISHIRING", 3));
    }
}
