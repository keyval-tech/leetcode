package com.kovizone.leetcode.page04;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/">438. 找到字符串中所有字母异位词</a>
 *
 * @author KV
 * @since 2022/08/11
 */
public class Solution0438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();
        if (sLength >= pLength) {
            char[] sChars = s.toCharArray();
            char[] pChars = p.toCharArray();
            int[] sArr = new int[26];
            int[] pArr = new int[26];
            for (int i = 0; i < sLength; i++) {
                if (i < pLength) {
                    pArr[pChars[i] - 'a']++;
                } else {
                    sArr[sChars[i - pLength] - 'a']--;
                }
                sArr[sChars[i] - 'a']++;

                if (i >= pLength - 1 && Arrays.equals(sArr, pArr)) {
                    ans.add(i - pLength + 1);
                }
            }
        }
        return ans;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() > p.length()) {
            Set<String> anagrams = anagrams(p);
            System.out.println("anagrams: " + anagrams);
            int p1 = 0;
            int p2 = p.length();
            while (p2 <= s.length()) {
                System.out.println("subStr: " + s.substring(p1, p2));
                if (anagrams.contains(s.substring(p1, p2))) {
                    ans.add(p1);
                }
                p1++;
                p2++;
            }
        }
        return ans;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() >= p.length()) {
            char[] pChars = p.toCharArray();

            Map<Character, Integer> counter = new HashMap<>();
            for (char pChar : pChars) {
                counter.put(pChar, counter.containsKey(pChar) ? counter.get(pChar) + 1 : 1);
            }
            Set<Character> check = new HashSet<>(counter.keySet());

            int pLength = p.length();
            char[] sChars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                System.out.println();
                System.out.println("i: " + i + ", if ans: " + (i - pLength + 1));
                System.out.println(counter);
                if (i >= pLength) {
                    char c = sChars[i - pLength];
                    System.out.print("+" + c + " ");
                    if (counter.containsKey(c)) {
                        counter.put(c, counter.get(c) + 1);
                        if (counter.get(c) != 0) {
                            check.add(c);
                        } else {
                            check.remove(c);
                        }
                    }
                }

                char c = sChars[i];
                System.out.println("-" + c + " ");
                if (counter.containsKey(c)) {
                    counter.put(c, counter.get(c) - 1);
                    if (counter.get(c) == 0) {
                        check.remove(c);
                    }
                }
                System.out.println(counter);
                System.out.println("check: " + check);
                if (check.isEmpty()) {
                    ans.add(i - pLength + 1);
                    System.out.println("ans: " + ans);
                }
            }
        }
        System.out.println();
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0438().findAnagrams(
                "ab",
                "ba"));
    }

    public Set<String> anagrams(String p) {
        Set<String> anagrams = new HashSet<>();
        anagrams(anagrams, new ArrayList<>(), p.toCharArray());
        return anagrams;
    }

    public void anagrams(Set<String> characterList, List<Integer> prefixIndex, final char[] source) {
        if (prefixIndex.size() == source.length) {
            StringBuilder str = new StringBuilder();
            for (Integer i : prefixIndex) {
                str.append(source[i]);
            }
            characterList.add(str.toString());
        } else {
            for (int i = 0; i < source.length; i++) {
                if (!prefixIndex.contains(i)) {
                    List<Integer> newPrefixIndex = new ArrayList<>(prefixIndex);
                    newPrefixIndex.add(i);
                    anagrams(characterList, newPrefixIndex, source);
                }
            }
        }
    }


}