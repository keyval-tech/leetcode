package com.kovizone.leetcode.solution;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/">1233. 删除子文件夹</a>
 * <p>
 * #广度优先搜索 #数组 #矩阵 #中等
 *
 * @author KV
 * @since 2023/02/08
 */
public class Solution1233M {
    public List<String> removeSubfolders(String[] folder) {
        if (folder.length == 1) {
            return Arrays.asList(folder);
        }

        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));

        for (String f : folder) {
            int n = f.length();
            for (int i = 1; i < n - 1; i++) {
                if (f.charAt(i) == '/' && folderSet.contains(f.substring(0, i))) {
                    folderSet.remove(f);
                    break;
                }
            }
        }

        return new ArrayList<>(folderSet);
    }

    public List<String> removeSubfolders1(String[] folder) {
        if (folder.length == 1) {
            return Arrays.asList(folder);
        }

        List<String> folderList = new ArrayList<>(Arrays.asList(folder));
        Collections.sort(folderList);

        Iterator<String> iterator = folderList.iterator();
        String p = iterator.next();

        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.startsWith(p + "/")) {
                iterator.remove();
            } else {
                p = s;
            }
        }

        return folderList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1233M().removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"}));
    }
}
