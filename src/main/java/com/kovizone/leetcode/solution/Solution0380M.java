package com.kovizone.leetcode.solution;

import java.util.*;

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

        List<Integer> nums;
        Map<Integer, Integer> indexMap;
        Random random;

        public RandomizedSet() {
            nums = new ArrayList<>();
            indexMap = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (nums.contains(val)) {
                return false;
            }
            int newIndex = nums.size();
            nums.add(val);
            indexMap.put(val, newIndex);
            return true;
        }

        public boolean remove(int val) {
            Integer index = indexMap.get(val);
            if (index == null) {
                return false;
            }
            // 要删除的元素，是list的最后一个时
            int lastIndex = nums.size() - 1;
            if (index == lastIndex) {
                nums.remove(lastIndex);
                indexMap.remove(val);
                return true;
            }

            // 最后一个元素与其交换
            int lastVal = nums.get(lastIndex);
            nums.remove(lastIndex);
            nums.set(index, lastVal);
            indexMap.remove(val);
            indexMap.put(lastVal, index);
            return true;
        }

        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }
}
