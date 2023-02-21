package com.whl.leetcode;


import java.util.*;

/**
 * 作者：whl
 * 日期：2023-02-20 13:16
 * 描述：给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。
 *
 * 下述是从好到坏你可能持有的 手牌类型 ：
 *
 * "Flush"：同花，五张相同花色的扑克牌。
 * "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
 * "Pair"：对子，两张大小一样的扑克牌。
 * "High Card"：高牌，五张大小互不相同的扑克牌。
 *
 * 请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。
 */
public class Day4 {
    public static void main(String[] args) {
        int[] ranks = new int[]{9,2,13,1,2};
        char[] suits = new char[]{'b','d','d','b','c'};
        String s = bestHand(ranks, suits);
        System.out.println(s);
    }

    public static String bestHand(int[] ranks, char[] suits) {
        String result = "";
        if(ranks.length != 5 || suits.length != 5){
            result = "failure";
            return result;
        }
        int count = 0;
        //Flush判断
        for (int i = 0; i < suits.length; i++) {
            for (int j = i+1; j < suits.length; j++) {
                if (suits[i] == suits[j]){
                    count ++;
                }
            }
            if (count == 4){
                result = "Flush";
                return result;
            }
            count = 0;
        }
        //Three of a kind
        int k = 0;
        int[] ints = new int[]{0,0,0,0,0};
        for (int i = 0; i < ranks.length; i++) {
            for (int j = i+1; j < ranks.length; j++) {
                if (ranks[i] == ranks[j]){
                    ints[i] ++;
                }
            }
        }
        Arrays.sort(ints);
        switch (ints[4]){
            case 4:
                result = "Three of a Kind";
                break;
            case 3:
                result = "Three of a Kind";
                break;
            case 2:
                result = "Three of a Kind";
                break;
            case 1:
                result = "Pair";
                break;
            case 0 :
                result = "High Card";
                break;
        }
        return result;
    }
    //用官方解法：hashset 或 hashmap，size为1就是同花，为5就是高牌，其余情况再分别讨论
    public String bestHand2(int[] ranks, char[] suits) {
        Set<Character> suitsSet = new HashSet<Character>();
        for (char suit : suits) {
            suitsSet.add(suit);
        }
        if (suitsSet.size() == 1) {
            return "Flush";
        }
        Map<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int rank : ranks) {
            h.put(rank, h.getOrDefault(rank, 0) + 1);
        }
        if (h.size() == 5) {
            return "High Card";
        }
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            if (entry.getValue() > 2) {
                return "Three of a Kind";
            }
        }
        return "Pair";
    }


}
