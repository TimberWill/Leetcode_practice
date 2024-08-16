package com.whl.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 作者：whl
 * 日期：2023-03-22 13:35
 * 描述：假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 *
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 *
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 */
public class Day7 {
    public static void main(String[] args) {
        int[] scores = new int[]{4,5,6,5};
        int[] ages = new int[]{2,1,2,1};
        bestTeamScore(scores, ages);
    }
    public static int bestTeamScore(int[] scores, int[] ages) {
        //用hashmap存储对应的数据
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < scores.length; i++) {
            map.put(ages[i],scores[i]);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();


        return 1;
    }
}
