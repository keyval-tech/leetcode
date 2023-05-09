package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/number-of-digit-one/">233. 数字 1 的个数</a>
 *
 * @author KV
 * @since 2023/02/03
 */
public class Solution0233 {
    public int countDigitOne(int n) {

        if (n <= 9) {
            if (n >= 1) {
                return 1;
            } else {
                return 0;
            }
        }

        // 统计结果
        int count = 0;

        // 长度
        int length = String.valueOf(n).length();

        // 计算n的长度减一位数的最大值对k的统计
        // 如：若n是四位数，根据规律获得0~999的k统计
        int lengthFlag = length - 1;
        if (lengthFlag == 1) {
            count++;
        } else if (lengthFlag == 2) {
            count += 20;
        } else {
            count = (int) Math.pow(10, (lengthFlag - 1)) * lengthFlag;
        }

        // 游标，以为已经获取了n-1位数最大值的统计数，所以游标从n的长度位最小数开始
        // 如n是四位数，则游标从1000开始，这是4位数中的最小数
        int vernier = (int) Math.pow(10, lengthFlag);

        while (lengthFlag > 1) {

            // vernierNext - 游标每次递进的值
            // 刚好该值是规律中统计的增值
            int vernierNext = (int) Math.pow(10, lengthFlag);

            // defaultCount - 每阶段默认增幅
            int defaultCount = (int) Math.pow(10, (lengthFlag - 1)) * lengthFlag;

            while (vernier + vernierNext - 1 <= n) {
                char[] startNumChars = String.valueOf(vernier).toCharArray();
                for (int i = 0; i < length - lengthFlag; i++) {
                    if (Integer.parseInt(String.valueOf(startNumChars[i])) == 1) {
                        count += vernierNext;
                    }
                }
                count += defaultCount;
                vernier += vernierNext;
            }
            lengthFlag--;
        }

        // 计算剩余数
        for (long i = vernier; i <= n; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            for (char c : chars) {
                if (Integer.parseInt(String.valueOf(c)) == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
