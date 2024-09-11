package com.whl.leetcode.slidewindow;

import java.util.HashSet;

/**
 * @program: Hello-world
 * @description: 长度最小的子数组
 *          给定一个含有 n 个正整数的数组和一个正整数 target 。
 *          找出该数组中满足其总和大于等于 target 的长度最小的子数组
 *          [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * @author: whl
 * @create: 2024-09-05 14:54
 **/
public class Demo01 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
//        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int fast = slow;
        HashSet<Integer> set = new HashSet<>();
        int maxValue = Integer.MAX_VALUE;
        int sum = 0;
        while (fast < nums.length){
            for (int i = slow; i <= fast ; i++) {
                sum += nums[i];
                if (sum < target ){
                    fast ++;
                }else if (sum > target){
                    slow ++;
                    fast = slow;
                    sum = 0;
                }else {
                    set.add(fast - slow + 1);
                    sum = 0;
                }
            }
        }
        int count = 0;
        for (Integer i : set) {
            if (i > count){
                count = i;
            }
        }

        return count;
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == target){

                }
            }
        }

        int count = 0;
        for (Integer i : set) {
            if (i > count){
                count = i;
            }
        }


        return count;
    }
}
