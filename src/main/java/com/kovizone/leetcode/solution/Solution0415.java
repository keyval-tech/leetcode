package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/add-strings/">415. 字符串相加</a>
 *
 * @author KV
 * @since 2023/02/03
 */
public class Solution0415 {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int p = num1.length() - 1;
        int q = num2.length() - 1;

        int carry = 0;
        while (p >= 0 || q >= 0) {
            int number1 = p >= 0 ? chars1[p--] : 48;
            int number2 = q >= 0 ? chars2[q--] : 48;
            int num = number1 + number2 + carry - 96;
            carry = num / 10;
            result.insert(0, num % 10);
        }
        if (carry > 0) {
            result.insert(0, carry);
        }

        return result.toString();
    }
}
