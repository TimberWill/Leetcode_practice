package com.whl.leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @program: Hello-world
 * @description: 合并区间
 * @author: whl
 * @create: 2024-11-27 11:21
 **/
public class Demo02 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[i].length; j++) {
                System.out.print(merge[i][j] + ",");
            }
            System.out.println();
        }

    }
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0 ||intervals ==null){
            return new int[0][0];
        }

        ArrayList<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparing(a->a[0]));

        int[] currentVal = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] nextVal = intervals[i];
            //有重叠
            if (currentVal[1] >= nextVal[0]){
                currentVal[1] = Math.max(currentVal[1], nextVal[1]);
            }else {
                result.add(currentVal);
                currentVal = nextVal;//更新
            }
        }
        result.add(currentVal);
        //改进了
//        for (int i = 0; i < intervals.length-1; i++) {
//            int[] val1 = intervals[i];
//            int[] val2 = intervals[i+1];
//
//            //有重叠
//            if (val1[1] >= val2[0]){
//                int[] ints = new int[2];
//                ints[0] = val1[0];
//                ints[1] = Math.max(val1[1],val2[1]);
//
//                intervals[i] = null;
//                intervals[i+1] = ints;
//                if (i == intervals.length - 2){
//                    result.add(ints);
//                }
//            }else {
//                //无重叠
//                result.add(val1);
//                if (i== intervals.length-2){
//                    result.add(val2);
//                }
//            }
//        }

        return result.toArray(new int[result.size()][]);
    }
}
