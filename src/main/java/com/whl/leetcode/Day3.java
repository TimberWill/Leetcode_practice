package com.whl.leetcode;


import java.util.ArrayDeque;

/**
 * 作者：whl
 * 日期：2023-02-14 11:37
 * 描述：给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 *
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 *
 * 请你返回「表现良好时间段」的最大长度。
 *
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 *
 * 输入：hours = [6,6,6]
 * 输出：0
 *
 * --贪心
 */
public class Day3 {
    public static void main(String[] args) {
        int[] input = new int[]{9,9,6,6,6,9,6};
        int i = longestWPI(input);
        System.out.println(i);

    }
    public static int longestWPI(int[] hours) {
        int[] ints = new int[hours.length];
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8){
                ints[i] = 1;
            }else {
                ints[i] = -1;
            }
        }
        int[] s = new int[hours.length+1];//前缀和
        s[0] =  0;
        ArrayDeque<Integer> integers = new ArrayDeque<>();//双端队列数组
        integers.push(0);
        for (int i = 1; i < s.length; i++) {
            s[i] = s[i-1] + ints[i-1];
            if (s[integers.peek()] > s[i]){
                integers.push(i);
            }
        }
        int res = 0;
        for (int r = hours.length; r >= 1; r--) {
            while (!integers.isEmpty() && s[integers.peek()] < s[r]){
                res = Math.max(res,r-integers.pop());
            }
        }
        return res;
    }
}
