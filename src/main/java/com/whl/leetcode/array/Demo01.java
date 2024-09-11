package com.whl.leetcode.array;

/**
 * @program: Hello-world
 * @description: 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @author: whl
 * @create: 2024-08-16 11:17
 **/
public class Demo01 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        rotate1(ints, 3);
    }
    public static void rotate1(int[] nums, int k) {
        if (nums.length < 1 || k <0){
            return;
        }
        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[(i+k) % nums.length] = nums[i] ;
        }
        System.arraycopy(ints, nums.length, nums,0,nums.length);
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0,nums.length);
        reverse(nums,0,k-1);
        reverse(nums,k, nums.length-1);
    }
    public void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}
