package com.whl.leetcode.binarysearch;

/**
 * @program: Hello-world
 * @description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * @author: whl
 * @create: 2024-11-25 10:42
 **/
public class Demo01 {
    public static void main(String[] args) {
        int i = searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println(i);
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (right - left)/2 + left;
            if (target < nums[mid]){
                right  = mid -1;
            }else if (target > nums[mid]){
                left = mid +1;
            }else {
                return mid;
            }
        }

        return left ;
    }
}
