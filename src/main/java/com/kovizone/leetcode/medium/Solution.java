package com.kovizone.leetcode.medium;

/**
 * Answer
 *
 * @author KV
 * @since 2022/06/22
 */
public class Solution {

    /**
     * 513
     */
    public static class FindBottomLeftValueSolution {

        public int findBottomLeftValue(TreeNode root) {
            findBottomLeftValue(root, 1);
            return maxVal;
        }

        int maxDepth = 0;
        int maxVal = 0;

        public void findBottomLeftValue(TreeNode root, int currentDepth) {
            if (root != null) {
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                    maxVal = root.val;
                }
                if (root.left != null) {
                    findBottomLeftValue(root.left, currentDepth + 1);
                }
                if (root.right != null) {
                    findBottomLeftValue(root.right, currentDepth + 1);
                }
            }
        }
    }

    /**
     * 1300
     */
    public static class SumOfMutatedArrayClosestToTargetSolution {

        public int findBestValue(int[] arr, int target) {
            if (target == 0) {
                return 0;
            }
            int minDif = target;
            int value = 0;

            for (int i = 1; i <= target; i++) {
                int sum = sum(arr, i);
                int dif = Math.abs(target - sum(arr, i));
                System.out.println("i: " + i + ", dif: " + dif + ", sum: " + sum + ", minDif: " + minDif);
                if (dif < minDif) {
                    minDif = dif;
                    value = i;
                } else {
                    break;
                }
            }
            return value;
        }

        private int sum(int[] arr, int min) {
            int result = 0;
            for (int i : arr) {
                result += (Math.min(i, min));
            }
            return result;
        }
    }

    /**
     * 2129
     */
    public static class CapitalizeTheTitle {
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
            System.out.println(new CapitalizeTheTitle().capitalizeTitle("capiTalIze tHe titLe"));
            System.out.println(new CapitalizeTheTitle().capitalizeTitle("First leTTeR of EACH Word"));
        }
    }

    /**
     * 2132
     */
    public static class StampingTheGrid {
        public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
            return false;
        }
    }
}
