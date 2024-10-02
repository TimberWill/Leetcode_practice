package com.whl.od.search;

import java.util.*;

/**
 * @program: Hello-world
 * @description: 查找兄弟单词
 * 定义一个单词的 “兄弟单词 ”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
 * 现在给定你 n 个单词，另外再给你一个单词 x ，让你寻找 x 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
 * 注意：字典中可能有重复单词。
 * 数据范围：1≤n≤1000 ，输入的字符串长度满足 1≤len(str)≤10  ， 1≤k<n
 * @author: whl
 * @create: 2024-10-01 13:46
 **/
public class Demo01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] split = s.split(" ");

        int n = Integer.parseInt(split[0]);
        String x = split[split.length - 2];
        int k = Integer.parseInt(split[split.length - 1]);

        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (split[i].equals(x) || split[i].length() != x.length()){
                continue;
            }

            if (isBrotherWord(split[i],x)){
                result.add(split[i]);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        if (k <= result.size()){
            System.out.println(result.get(k-1));
        }

    }

    public static boolean isBrotherWord(String a, String b){
        char[] aList = a.toCharArray();
        char[] bList = b.toCharArray();
        Arrays.sort(aList);
        Arrays.sort(bList);
        if (Arrays.equals(aList,bList)){
            return true;
        }else {
            return false;
        }
    }

}
