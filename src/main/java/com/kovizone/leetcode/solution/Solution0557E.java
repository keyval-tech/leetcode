package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string-iii/">557. 反转字符串中的单词 III</a>
 * <p>
 * #双指针 #字符串 #简单
 *
 * @author KV
 * @since 2022/07/07
 */
public class Solution0557E {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int a = 0;
        int b = 0;
        while (b < chars.length) {
            if (chars[b] == ' ') {
                reverse(chars, a, b - 1);
                a = b + 1;
            }
            b++;
        }
        reverse(chars, a, b - 1);
        return new String(chars);
    }

    public void reverse(char[] arr, int begin, int end) {
        while (begin < end) {
            char t = arr[begin];
            arr[begin++] = arr[end];
            arr[end--] = t;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0557E().reverseWords("Let's take LeetCode contest"));
    }
}
