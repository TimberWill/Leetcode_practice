package com.whl.interview;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;

/**
 * @program: Hello-world
 * @description:
 *      给定一个正整数数组a，以及一个目标数字x，使用你最熟悉的语言，编写一个函数，找出数组中所有可以使数字之和等于x的组合g（组合不能重复）。
 *      注：数组中的数字可以无限制被重复选取。
 *      例如：a = [2,3,5,6,8]，x = 8，g = [[2,2,2,2], [2,3,3], [2,6], [8], [3,5]]
 * @author: whl
 * @create: 2024-09-06 14:02
 **/
public class Demo01 {
    public static void main(String[] args) {
//        System.out.println(method01(new int[]{2, 3, 5, 6, 8}, 8));
        System.out.println(combination(new int[]{2, 3, 5, 6, 8}, 8));
    }
    public static HashSet<List<Integer>> method01(int[] a, int x){
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (x % a[j] == 0){
                    int num = x/a[j];
                    for (int k = 0; k < num; k++) {
                        list.add(a[j]);
                    }
                    break;
                }else if (x-sum == a[j]){
                    list.add(a[j]);
                    break;
                }
            }
            int verify = 0;
            for (Integer integer : list) {
                verify += integer;
            }
            if (!list.isEmpty() && verify == x){
                set.add(list);
                sum = 0;
            }
        }

        return set;
    }

    public static HashSet<List<Integer>> combination(int[] a, int x){
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        traceBack(a, x, 0, set, list);
        return set;
    }

    public static void traceBack(int[] a, int remaining, int start, HashSet<List<Integer>> result, List<Integer> list){
        if (remaining == 0){
            //保存副本
            result.add(new ArrayList<>(list));
        }
        for (int i = start; i < a.length; i++) {
            if (a[i] <= remaining){
                list.add(a[i]);
                traceBack(a, remaining-a[i], i, result, list);
                list.remove(list.size()-1);//从后往前 逐步替换元素
            }
        }

    }
}
