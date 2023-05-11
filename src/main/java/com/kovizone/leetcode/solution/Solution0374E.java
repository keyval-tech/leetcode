package com.kovizone.leetcode.solution;

import cn.hutool.core.util.NumberUtil;

/**
 * <a href="https://leetcode.cn/problems/guess-number-higher-or-lower/">374. 猜数字大小</a>
 * <p>
 * #二分查找 #交互 #简单
 *
 * @author KV
 * @since 2022/08/05
 */
public class Solution0374E {

    public int guessNumber(int n) {
        this.randomInt = 6;
        System.out.println("randomInt: " + randomInt);
        return guessNumber(0, n);
    }

    private int guessNumber(int l1, int l2) {
        if (l1 == l2) {
            return l1;
        }
        int c = (l2 - l1) / 2 + l1;
        if (guess(c) > 0) {
            return guessNumber(c + 1, l2);
        } else {
            return guessNumber(l1, c);
        }
    }

    private int randomInt;

    private int guess(int num) {
        return NumberUtil.compare(randomInt, num);
    }

    public static void main(String[] args) {
        new Solution0374E().guessNumber(10);
    }


}
