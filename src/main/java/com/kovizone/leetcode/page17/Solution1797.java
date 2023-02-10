package com.kovizone.leetcode.page17;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/design-authentication-manager/">1797. 设计一个验证系统</a>
 *
 * @author KV
 * @since 2023/02/09
 */
public class Solution1797 {

    final int timeToLive;

    Map<String, Integer> map = new HashMap<>();

    public Solution1797(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        Integer timeout = map.get(tokenId);
        if (timeout != null && timeout > currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int ans = 0;
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            if (entry.getValue() > currentTime) {
                ans++;
            }
        }
        return ans;
    }
}
