package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/multiply-strings/">43. 字符串相乘</a>
 *
 * @author KV
 * @since 2023/02/03
 */
public class Solution0043 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        StringBuilder result = new StringBuilder();
        int[] array = new int[length1 + length2 - 1];
        int carry = 0;
        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = length2 - 1; j >= 0; j--) {
                array[(length1 - 1 - i) + (length2 - 1 - j)] += (chars1[i] - 48) * (chars2[j] - 48);
            }

            int num = array[length1 - 1 - i] + carry;
            result.insert(0, num % 10);
            carry = num / 10;
        }
        for (int i = length1; i < array.length; i++) {
            int num = array[i] + carry;
            result.insert(0, num % 10);
            carry = num / 10;
        }
        if (carry > 0) {
            result.insert(0, carry);
        }
        return result.toString();
    }
}
