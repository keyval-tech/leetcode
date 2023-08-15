package com.kovizone.leetcode.solution;

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
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        int i = 0;

        while (i < chars.length) {
            int p = -1;
            for (int j = 0; j < indices.length; j++) {
                if (i == indices[j]) {
                    p = j;
                    break;
                }
            }
            if (p == -1) {
                result.append(chars[i]);
                i++;
                continue;
            }

            boolean check = (i + sources[p].length()) <= chars.length;
            if (check) {
                for (int k = 0; k < sources[p].length(); k++) {
                    if (chars[i + k] != sources[p].charAt(k)) {
                        check = false;
                        break;
                    }
                }
            }

            if (check) {
                result.append(targets[p]);
                i += sources[p].length();
            } else {
                result.append(chars[i]);
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution0833M().findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "ffff"}));
    }
}
