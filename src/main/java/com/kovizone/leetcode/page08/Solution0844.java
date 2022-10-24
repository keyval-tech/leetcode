package com.kovizone.leetcode.page08;

/**
 * <a href="https://leetcode.cn/problems/backspace-string-compare/">844. 比较含退格的字符串</a>
 *
 * @author KV
 * @since 2022/08/10
 */
public class Solution0844 {
    public boolean backspaceCompare(String s1, String s2) {
        int p1 = s1.length() - 1;
        int p2 = s2.length() - 1;

        int p1b = 0;
        int p2b = 0;

        while (p1 >= 0 || p2 >= 0) {
            Character check1 = null;
            while (p1 >= 0) {
                if (s1.charAt(p1) == '#') {
                    p1b++;
                } else if (p1b > 0) {
                    p1b--;
                } else {
                    check1 = s1.charAt(p1);
                    p1--;
                    break;
                }
                p1--;
            }

            Character check2 = null;
            while (p2 >= 0) {
                if (s2.charAt(p2) == '#') {
                    p2b++;
                } else if (p2b > 0) {
                    p2b--;
                } else {
                    check2 = s2.charAt(p2);
                    p2--;
                    break;
                }
                p2--;
            }

            if (!equals(check1, check2)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Character c1, Character c2) {
        System.out.printf("check: %s %s%n", c1, c2);
        if (c1 == null && c2 == null) {
            return true;
        }
        if (c1 == null || c2 == null) {
            return false;
        }
        return c1.equals(c2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0844().backspaceCompare("a#bb", "c#b"));
        System.out.println();
        System.out.println(new Solution0844().backspaceCompare("ab", "b"));
    }

    private String sdf(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '#') {
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
