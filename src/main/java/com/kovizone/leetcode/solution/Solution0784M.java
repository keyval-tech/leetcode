package com.kovizone.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/letter-case-permutation/">784. 字母大小写全排列</a>
 * <p>
 * #位运算 #字符串 #回溯 #中等
 *
 * @author KV
 * @since 2022/08/02
 */
public class Solution0784M {

    public List<String> letterCasePermutation(String s) {
        List<String> stringList = new ArrayList<>();
        letterCasePermutation(stringList, s.toCharArray(), 0);
        return stringList;
    }

    public void letterCasePermutation(List<String> stringList, char[] chars, int i) {
        if (i == chars.length) {
            stringList.add(new String(chars));
        } else {
            letterCasePermutation(stringList, chars, i + 1);
            if (chars[i] >= 'A') {
                chars[i] ^= ' ';
                letterCasePermutation(stringList, chars, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0784M().letterCasePermutation("a1b2"));
    }
}
