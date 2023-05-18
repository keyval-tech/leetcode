package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/integer-to-roman/">12. 整数转罗马数字</a>
 * <p>
 * #哈希表 #数学 #字符串 #中等 #面试经典150题
 *
 * @author KV
 * @since 2023/05/18
 */
public class Solution0012M {

    private static final String[] THOUSANDS = {"", "M", "MM", "MMM"};
    private static final String[] HUNDREDS = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] TENS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ONES = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num) {
        return THOUSANDS[num / 1000] + HUNDREDS[num % 1000 / 100] + TENS[num % 100 / 10] + ONES[num % 10];
    }


    private String sdf(int num) {
        switch (num) {
            case 1:
                return "I";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 900:
                return "CM";
            case 1000:
                return "M";
            default:
                return "";
        }
    }
}
