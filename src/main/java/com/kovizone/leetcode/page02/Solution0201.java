package com.kovizone.leetcode.page02;

/**
 * <a href="https://leetcode.cn/problems/bitwise-and-of-numbers-range/">201. 数字范围按位与</a>
 *
 * @author KV
 * @since 2023/02/06
 */
public class Solution0201 {

    public int rangeBitwiseAnd2(int left, int right) {
        int x = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            x++;
        }
        return left << x;
    }

    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right = right & (right - 1);
        }
        return right;
    }

}
