package com.whl.od.String;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Scanner;

/**
 * @program: Hello-world
 * @description: 字符串排序
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *      如，输入： Type 输出： epTy
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *      如，输入： BabA 输出： aABb
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *      如，输入： By?e 输出： Be?y
 * 数据范围：输入的字符串长度满足 1≤n≤1000
 * @author: whl
 * @create: 2024-09-30 10:04
 **/
public class Demo04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String s = in.nextLine();
            if (s.length() > 1000 || s.isEmpty()){
                return;
            }
            char[] charArray = s.toCharArray();

            //额外开辟一个list，复制字母并排序
            List<Character> list = new ArrayList<>();
            int asc = 65;
            while (asc <= 90){
                for (char c : charArray) {
                    //是字母的直接加入newArray，
                    if (Character.isLetter(c)) {
                        if (c == asc || c == asc + 32) {
                            list.add(c);
                        }
                    }

                }
                asc ++;
            }

            //替换原数组中的字母
            int j = 0;
            for (int i = 0; i < charArray.length; i++) {
                if (Character.isLetter(charArray[i])){
                    charArray[i] = list.get(j);
                    j++;
                }
            }

            System.out.println(String.valueOf(charArray));
        }
    }
}
