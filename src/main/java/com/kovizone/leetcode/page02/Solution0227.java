package com.kovizone.leetcode.page02;

/**
 * <a href="https://leetcode.cn/problems/basic-calculator-ii/">227. 基本计算器 II</a>
 *
 * @author KV
 * @since 2023/02/03
 */
public class Solution0227 {
    public int calculate(String s) {
        char[] numbers = s.toCharArray();

        // 结果
        int result = 0;

        //运算符
        char operator = '+';
        char operatorTemp = ' ';

        int num = 0;
        int numTemp = 0;

        for (char point : numbers) {
            if (point >= 48 && point <= 57) {
                num = num * 10 + (point - 48);
            } else if (point != ' ') {
                if (operatorTemp != ' ') {
                    num = compute(numTemp, operatorTemp, num);
                    operatorTemp = ' ';
                    numTemp = 0;
                }
                if (point != '*' && point != '/') {
                    result = compute(result, operator, num);
                    num = 0;
                }
            }
            if (point == '*' || point == '/') {
                numTemp = num;
                num = 0;
                operatorTemp = point;
            }

            if (point == '+') {
                operator = '+';
            }
            if (point == '-') {
                operator = '-';
            }
        }
        if (operatorTemp != ' ') {
            num = compute(numTemp, operatorTemp, num);
        }
        return compute(result, operator, num);
    }

    /**
     * 计算
     *
     * @param left     左数
     * @param operator 计算符
     * @param right    右数
     * @return 计算结果
     */
    private int compute(int left, char operator, int right) {
        if (right != 0) {
            if (operator == '+') {
                return left + right;
            }
            if (operator == '-') {
                return left - right;
            }
            if (operator == '*') {
                return left * right;
            }
            if (operator == '/') {
                return left / right;
            }
        }
        return left;
    }
}
