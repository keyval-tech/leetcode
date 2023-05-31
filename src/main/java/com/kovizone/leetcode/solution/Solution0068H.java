package com.kovizone.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/text-justification/">68. 文本左右对齐</a>
 * <p>
 * #数组 #字符串 #模拟 #困难 #面试经典150题
 *
 * @author KV
 * @since 2023/05/31
 */
public class Solution0068H {

    public static void main(String[] args) {
        List<String> stringList = new Solution0068H().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = 0;
        int l = 0;
        int r = 0;
        List<String> res = new ArrayList<>();
        while (r < words.length) {
            int length = words[r].length();
            if (length + n > maxWidth) {
                res.add(joinSpace(words, l, r - 1, maxWidth, false));
                l = r;
                n = 0;
            }
            if (r == words.length - 1) {
                res.add(joinSpace(words, l, r, maxWidth, true));
                return res;
            }
            r++;
            n += length + 1;

        }
        return res;
    }

    public String joinSpace(String[] words, int l, int r, int maxWidth, boolean isLast) {
        int diff = r - l;
        int maxSpace = maxWidth;
        for (int i = l; i <= r; i++) {
            maxSpace -= words[i].length();
        }
        int spaceSize = isLast || diff == 0 ? 1 : (maxSpace / diff);
        int spaceDiff = isLast || diff == 0 ? 0 : (maxSpace % diff);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = l; i <= r; i++) {
            stringBuilder.append(words[i]);
            if (i < r) {
                stringBuilder.append(multipleSpace(spaceSize + (i - l < spaceDiff ? 1 : 0)));
            }
        }
        if (stringBuilder.length() < maxWidth) {
            stringBuilder.append(multipleSpace(maxWidth - stringBuilder.length()));
        }
        return stringBuilder.toString();
    }

    public String multipleSpace(int size) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}