package com.kovizone.leetcode.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/insert-delete-getrandom-o1/">380. O(1) 时间插入、删除和获取随机元素</a>
 * <p>
 * 难度：中等
 * <p>
 * 标签：#设计 #数组 #哈希表 #数学 #随机化
 *
 * @author KV
 * @since 2023/05/10
 */
public interface Solution0380M {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(3));
        System.out.println(randomizedSet.remove(3));
        System.out.println(randomizedSet.remove(3));
        System.out.println(randomizedSet.insert(3));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(3));
    }

    class RandomizedSet {

        int[] nums;
        Map<Integer, Integer> indexMap;
        Random random;
        int lastIndex;

        public RandomizedSet() {
            nums = new int[200001];
            indexMap = new HashMap<>();
            random = new Random();
            lastIndex = -1;
        }

        public boolean insert(int val) {
            Integer index = indexMap.get(val);
            if (index != null) {
                return false;
            }
            lastIndex++;
            nums[lastIndex] = val;
            indexMap.put(val, lastIndex);
            return true;
        }

        public boolean remove(int val) {
            Integer index = indexMap.get(val);
            if (index == null) {
                return false;
            }
            // 要删除的元素，是list的最后一个时
            int lastVal = nums[lastIndex];
            lastIndex--;
            indexMap.remove(val);
            if (val == lastVal) {
                return true;
            }

            // 最后一个元素与其交换
            nums[index] = lastVal;
            indexMap.put(lastVal, index);
            return true;
        }

        public int getRandom() {
            return nums[random.nextInt(lastIndex + 1)];
        }
    }
}
