package com.kovizone.leetcode.page00;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/">17. 电话号码的字母组合</a>
 *
 * @author KV
 * @since 2022/10/20
 */
public class Solution0017 {

    private final static Map<Character, Character[]> CACHE = new HashMap<>();

    static {
        CACHE.put('2', new Character[]{'a', 'b', 'c'});
        CACHE.put('3', new Character[]{'d', 'e', 'f'});
        CACHE.put('4', new Character[]{'g', 'h', 'i'});
        CACHE.put('5', new Character[]{'j', 'k', 'l'});
        CACHE.put('6', new Character[]{'m', 'n', 'o'});
        CACHE.put('7', new Character[]{'p', 'q', 'r', 's'});
        CACHE.put('8', new Character[]{'t', 'u', 'v'});
        CACHE.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits != null && !digits.isEmpty()) {
            sdf(ans, digits, 0, new StringBuilder());
        }
        return ans;
    }

    private void sdf(List<String> ans,
                     final String digits,
                     final int idx,
                     StringBuilder perm) {
        if (perm.length() == digits.length()) {
            ans.add(perm.toString());
            return;
        }

        Character[] letters = CACHE.get(digits.charAt(idx));
        for (Character letter : letters) {
            perm.append(letter);
            sdf(ans, digits, idx + 1, perm);
            perm.deleteCharAt(idx);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0017().letterCombinations("23"));
    }
}
