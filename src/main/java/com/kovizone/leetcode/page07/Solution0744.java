package com.kovizone.leetcode.page07;

/**
 * <a href="https://leetcode.cn/problems/find-smallest-letter-greater-than-target/">744. 寻找比目标字母大的最小字母</a>
 *
 * @author KV
 * @since 2022/08/08
 */
public class Solution0744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        if (letters[r] <= target) {
            return letters[0];
        }
        while (l < r) {
            int c = (r - l) / 2 + l;
            System.out.printf("l: %d, r: %d, c: %d, letter: %s%n", l, r, c, letters[c]);

            if (letters[c] <= target) {
                l = c + 1;
            } else {
                r = c;
            }
        }
        return letters[l];
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }
        char nextGreatestLetter = 'z';
        int min = 'z';
        for (char letter : letters) {
            if (letter == target) {
                continue;
            }
            int difference = letter + (letter < target ? 26 : 0) - target;
            if (difference > 0 && difference < min) {
                min = difference;
                nextGreatestLetter = letter;
            }
        }
        return nextGreatestLetter;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0744().nextGreatestLetter(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}, 'd'));
    }
}