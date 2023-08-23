package com.kovizone.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-and-replace-in-string/">833. 字符串中的查找与替换</a>
 * <p>
 * #数组 #字符串 #排序 #中等
 *
 * @author KV
 * @since 2023/08/15
 */
public class Solution0833M {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            if (!map.containsKey(indices[i]) && s.startsWith(sources[i], indices[i])) {
                map.put(indices[i], i);
            }
        }
        if (map.isEmpty()) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            Integer j = map.get(i);
            if (j != null) {
                result.append(targets[j]);
                i += sources[j].length();
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution0833M().findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "ffff"}));
    }
}
