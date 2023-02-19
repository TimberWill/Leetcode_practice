package com.whl.leetcode;

import java.util.Arrays;

/**
 * 作者：whl
 * 日期：2023-02-11 14:02
 * 描述：现有一台饮水机，可以制备冷水、温水和热水。每秒钟，可以装满 2 杯 不同 类型的水或者 1 杯任意类型的水。
 * 给你一个下标从 0 开始、长度为 3 的整数数组 amount ，其中 amount[0]、amount[1] 和 amount[2] 分别表示需要装满冷水、温水和热水的杯子数量。返回装满所有杯子所需的 最少 秒数。
 *
 * 贪心 + 分类讨论
 * 
 */
public class Day2 {

    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int count = 0;

        if (amount[0] + amount[1] < amount[2]){
            count = amount[2];
        }else {
            count = (amount[0]+amount[1]+amount[2])/2;
        }

        return count;
    }
}
