package com.whl.leetcode.dualindex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: Hello-world
 * @description: 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * @author: whl
 * @create: 2024-10-30 11:29
 **/
public class Demo01 {

    public static void main(String[] args) {
        int[] ints = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(ints));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3 || nums.length > 3000){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            //跳过重复的i
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    //跳过重复的left
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    //跳过重复的right
                    while (left < right && nums[right] == nums[right - 1]){
                        right --;
                    }
                    left++;
                    right--;

                }else if (sum < 0){
                    left ++;
                }else {
                    right --;
                }
            }
        }

        return result;
    }
}
