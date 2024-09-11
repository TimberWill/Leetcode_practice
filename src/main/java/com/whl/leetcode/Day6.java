package com.whl.leetcode;


/**
 * 作者：whl
 * 日期：2023-03-16 10:33
 * 描述：给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 */
public class Day6 {
    //超时解法
    public int maxArea_(int[] height) {
        int max = 0;//最大体积
        int v = 0;//当前体积
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (height[i] >= height[j]){
                    v = height[j] * (j-i);
                }else {
                    v = height[i] * (j-i);
                }
                if (max < v){
                    max = v;
                }
            }
        }
        return max;
    }

    //官方解法-左右双指针
    public static int maxArea(int[] height){
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i<j){
            max = (height[i] > height[j] ) ? Math.max(max, (j-i)*height[j--]) : Math.max(max, (j-i)*height[i++]);
        }
        return max;
    }
}
