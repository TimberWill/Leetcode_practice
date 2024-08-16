package com.whl.leetcode;

import java.util.HashMap;

/**
 * @program: Hello-world
 * @description: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * @author: whl
 * @create: 2024-05-30 10:06
 **/
public class Demo02 {

    //方法1
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }

    //方法2：利用哈希map，查找map中是否已经存在，与当前数组值和为target的值
    public int[] twoSum2(int[] nums, int target){

        //[1,2,3,4]  3
        int[] ints = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                ints[0] = map.get(target-nums[i]);
                ints[1] = i;
            }
            map.put(nums[i],i);
        }

        return ints;

    }


}
