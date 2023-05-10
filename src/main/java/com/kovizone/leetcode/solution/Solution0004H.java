package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/">4. 寻找两个正序数组的中位数</a>
 * <p>
 * #数组 #二分查找 #分治
 *
 * @author KV
 * @since 2023/02/03
 */
public class Solution0004H {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k1 = (nums1.length + nums2.length + 1) / 2;
        int k2 = (nums1.length + nums2.length + 2) / 2;
        int left = getKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k1);
        int right = getKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k2);
        return (left + right) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (len2 == 0) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int k2 = k / 2;
        int i = start1 + Math.min(k2, len1) - 1;
        int j = start2 + Math.min(k2, len2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
