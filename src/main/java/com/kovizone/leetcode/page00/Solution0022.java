package com.kovizone.leetcode.page00;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution0022
 *
 * @author KV
 * @since 2022/10/24
 */
public class Solution0022 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        sdf(ans, new StringBuilder(), n, n);
        return ans;
    }

    private final static String L = "(";
    private final static String R = ")";

    private void sdf(List<String> ans, StringBuilder perm, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(perm.toString());
            return;
        }
        if (left > 0) {
            perm.append(L);
            sdf(ans, perm, left - 1, right);
            perm.deleteCharAt(perm.length() - 1);
        }
        if (right > 0 && right > left) {
            perm.append(R);
            sdf(ans, perm, left, right - 1);
            perm.deleteCharAt(perm.length() - 1);
        }
    }


    public static void main(String[] args) {
        List<String> stringList = new Solution0022().generateParenthesis(4);
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
