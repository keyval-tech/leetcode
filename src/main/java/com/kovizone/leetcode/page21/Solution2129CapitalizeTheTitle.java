package com.kovizone.leetcode.page21;

/**
 * <a href="https://leetcode.cn/problems/capitalize-the-title/">2129. 将标题首字母大写</a>
 *
 * @author KV
 */
public class Solution2129CapitalizeTheTitle {
    public String capitalizeTitle(String title) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strs = title.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (i != 0) {
                stringBuilder.append(" ");
            }
            char[] chars = strs[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                if (j == 0 && chars.length > 2) {
                    if (c >= 97 && c <= 122) {
                        c = (char) (c - 32);
                    }
                } else if (c >= 65 && c <= 90) {
                    c = (char) (c + 32);
                }
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2129CapitalizeTheTitle().capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(new Solution2129CapitalizeTheTitle().capitalizeTitle("First leTTeR of EACH Word"));
    }
}
