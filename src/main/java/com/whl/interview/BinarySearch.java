package com.whl.interview;

import java.util.Arrays;

/**
 * @program: Hello-world
 * @description: 二分查找实现
 * @author: whl
 * @create: 2024-11-01 17:31
 **/
public class BinarySearch {



    public static void main(String[] args) {
        int[] ints = new int[]{1,4,2,6,8,3};
        int target = 4;
        Arrays.sort(ints);
        int i = binarySearch(ints, target);
        System.out.println(i);
    }

    public static int binarySearch(int[] ints, int target){

        int slow = 0;
        int fast = ints.length - 1;


        while (slow <= fast){
            int mid = slow + (fast - slow)/2;//注意下标计算
            if (ints[mid] > target){
                fast = mid - 1;
            }else if (ints[mid] < target){
                slow = mid + 1;
            }else {
                return mid;
            }

        }
        return -1;
    }

}
