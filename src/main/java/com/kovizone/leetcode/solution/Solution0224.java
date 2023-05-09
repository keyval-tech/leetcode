package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/basic-calculator/">224. 基本计算器</a>
 *
 * @author KV
 * @since 2023/02/03
 */
public class Solution0224 {
    public int calculate(String s) {
        char[] numbers = s.toCharArray();

        // 结果
        int result = 0;

        //运算符
        char operator = '+';

        // 栈
        char[] stack = new char[s.length() / 2];
        int stackTop = 0;

        int num = 0;

        for (int i = 0; i < numbers.length; i++) {
            char point = numbers[i];
            if (point >= 48 && point <= 57) {
                num = num * 10 + (point - 48);
            } else if (point != ' ') {
                result = compute(result, operator, num);
                num = 0;
            }
            if (point == '+') {
                if (stackTop > 0) {
                    if (stack[stackTop - 1] == '-') {
                        operator = '-';
                    }
                    if (stack[stackTop - 1] == '+') {
                        operator = '+';
                    }
                } else {
                    operator = '+';
                }
            }
            if (point == '-') {
                if (stackTop > 0) {
                    if (stack[stackTop - 1] == '-') {
                        operator = '+';
                    }
                    if (stack[stackTop - 1] == '+') {
                        operator = '-';
                    }
                } else {
                    operator = '-';
                }
            }
            if (point == '(') {
                stack[stackTop++] = operator;
            }
            if (point == ')') {
                stackTop--;
            }
        }
        return compute(result, operator, num);
    }

    /**
     * 计算
     * @param left 左数
     * @param operator 计算符
     * @param right 右数
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
        }
        return left;
    }
}
