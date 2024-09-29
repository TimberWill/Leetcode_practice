package com.whl.od.String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: Hello-world
 * @description: 动态规划-购物车
 *  输入描述：
 *      输入的第 1 行，为两个正整数N，m，用一个空格隔开：
 *      （其中 N （ N<32000 ）表示总钱数， m （m <60 ）为可购买的物品的个数。）
 *      从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 *      （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。
 *      如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 * 输出描述：
 *      输出一个正整数，为张强可以获得的最大的满意度。
 * @author: whl
 * @create: 2024-09-16 11:12
 **/
public class Demo02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int m = in.nextInt();

        if (N >= 3200 || m >= 60) return;

        List<Good> goods = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int v = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            if (v>=10000 || p<1 || p>5 || q<0) return;
            Good good = new Good(v, p, q);
            if (q>0){
                if (good.a1 > 0){
                    good.setA2(i+1);
                }
                good.setA1(i+1);
            }

            goods.add(good);
        }

        int happy = 0;
        List<Integer> result = new ArrayList<>();
        for (Good good : goods) {
            //主件
            if (good.q == 0){
                if (N - good.v >= 0){
                    happy += good.v * good.p;
                }

            }
        }

        System.out.println();

    }
    private static class Good{

        private int v;
        private int p;
        private int q;

        private int a1 = 0;
        private int a2 = 0;

        public Good(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }

    }
}
