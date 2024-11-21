package com.whl.od.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: Hello-world
 * @description: 明明的随机数
 * @author: whl
 * @create: 2024-11-20 10:56
 **/
public class Demo02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int N = in.nextInt();

            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(in.nextInt());
            }
            ArrayList<Integer> list = new ArrayList<>(set);
            Collections.sort(list);

            for (Integer i : list) {
                System.out.println(i);
            }

        }
    }
}
