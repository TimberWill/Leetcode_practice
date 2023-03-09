package com.whl.leetcode;

import java.util.*;

/**
 * 作者：whl
 * 日期：2023-03-09 15:16
 * 描述：最长回文串
 *      给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 *
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意：
 *  1. HashSet不区分大小写
 */
public class Day5 {
    public static void main(String[] args) {
        String s = "bb";
        int i = longestPalindrome(s);
        System.out.println(i);
    }

    public static int longestPalindrome(String s) {
        //字符数组
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        //计算器
        int count = 0;
        for (char aChar : chars) {
            for (int i = 0; i < chars.length; i++) {
                if (aChar == chars[i]){
                    count++;
                }
            }
            if (!map.containsKey(aChar)){
                map.put(aChar,count);
            }
            count = 0;
        }
        //计数器
        int num = 0;
        LinkedList<Character> linkedList = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            //奇数
            if (entry.getValue() % 2 == 1){
                if (num < 1){
                    for (int i = 0; i < entry.getValue(); i++) {
                        linkedList.add(linkedList.size()/2, entry.getKey());
                    }
                    num++;
                }else {
                    for (int i = 0; i < (entry.getValue() - 1)/2; i++) {
                        linkedList.addFirst(entry.getKey());
                        linkedList.addLast(entry.getKey());
                    }
                }
            }else {
                //偶数
                for (int i = 0; i < entry.getValue() / 2; i++) {
                    linkedList.addFirst(entry.getKey());
                    linkedList.addLast(entry.getKey());
                }
            }

        }
        int size = linkedList.size();

        return size;
    }
}
