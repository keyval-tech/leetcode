package com.kovizone.leetcode.solution;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/">1604. 警告一小时内使用相同员工卡大于等于三次的人</a>
 *
 * @author KV
 * @since 2023/02/07
 */
public class Solution1604 {

    public static void main1(String[] args) {
        System.out.println(new Solution1604().alertNames(
                new String[]{"a", "a", "a", "a", "a", "b", "b", "b", "b", "b", "b"},
                new String[]{"23:20", "11:09", "23:30", "23:02", "15:28", "22:57", "23:40", "03:43", "21:55", "20:38", "00:19"}
        ));
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {

        int n = keyName.length;

        Map<String, List<Integer>> group = new HashMap<>();

        for (int i = 0; i < n; i++) {
            group.computeIfAbsent(keyName[i], k -> new ArrayList<>())
                    .add(Integer.parseInt(keyTime[i].substring(0, 2)) * 60 + Integer.parseInt(keyTime[i].substring(3)));
        }

        List<String> names = new ArrayList<>();

        group.forEach((name, minuteList) -> {
            if (minuteList.size() >= 3) {
                Collections.sort(minuteList);

                int m = minuteList.size();
                int l = 0;
                int r = 2;

                while (r < m) {
                    if (minuteList.get(r) - minuteList.get(l) >= 60) {
                        names.add(name);
                        break;
                    }
                    l++;
                    r++;
                }
            }
        });

        Collections.sort(names);
        return names;
    }
}
