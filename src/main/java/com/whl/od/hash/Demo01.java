package com.whl.od.hash;

import java.util.*;

/**
 * @program: Hello-world
 * @description: 数据分类处理
    从R依次中取出R<i>，对I进行处理，找到满足条件的I：
 * I整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I为231，那么I包含了R<i>，条件满足 。
 * 按R<i>从小到大的顺序:
 * (1)先输出R<i>；
 * (2)再输出满足条件的I的个数；
 * (3)然后输出满足条件的I在I序列中的位置索引(从0开始)；
 * (4)最后再输出I。
 *
 * 输入：
 * 15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
 * 5 6 3 6 3 0
 * 输出：
 * 30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123 6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786
 * 说明：
 * 将序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）排序去重后，可得0,3,6。
 * 序列I没有包含0的元素。
 * 序列I中包含3的元素有：I[0]的值为123、I[3]的值为453、I[7]的值为3、I[9]的值为453456、I[13]的值为453、I[14]的值为123。
 * 序列I中包含6的元素有：I[1]的值为456、I[2]的值为786、I[4]的值为46、I[8]的值为665、I[9]的值为453456、I[11]的值为456、I[12]的值为786。
 * 最后按题目要求的格式进行输出即可。
 * @author: whl
 * @create: 2024-09-29 10:57
 **/
public class Demo01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s1 = in.nextLine();
        String s2 = in.nextLine();

        String[] split1 = s1.split(" ");
        String[] split2 = s2.split(" ");

        ArrayList<String> I = new ArrayList<>(Arrays.asList(split1).subList(1, split1.length));
        TreeSet<String> R = new TreeSet<>(Arrays.asList(split2).subList(1, split2.length));

        String out = "";
        int sum = 0;
        for (String r : R) {
            int times = 0;
            String s = "";
            for (int i = 0; i < I.size(); i++) {
                if (I.get(i).contains(r)){
                    times ++;
                    s = s + " " + i + " " + I.get(i);
                    sum +=2;
                }
            }
            if (times > 0){
                out = out + " " + r + " " + times + s;
                sum += 2;
            }
        }
        System.out.println(sum + out);

    }

    public static void method2() {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            int i_size = in.nextInt();
            ArrayList<String> I = new ArrayList<>(i_size);
            for (int i = 0; i < i_size; i++) {
                I.add(String.valueOf(in.nextInt()));
            }
            int r_size = in.nextInt();
            TreeSet<Integer> R = new TreeSet<>();
            for (int i = 0; i < r_size; i++) {
                R.add(in.nextInt());
            }

            String out = "";
            int sum = 0;
            for (int r : R) {
                int times = 0;
                String s = "";
                for (int i = 0; i < I.size(); i++) {
                    if (I.get(i).contains(String.valueOf(r))){
                        times ++;
                        s = s + " " + i + " " + I.get(i);
                        sum +=2;
                    }
                }
                if (times > 0){
                    out = out + " " + r + " " + times + s;
                    sum += 2;
                }
            }
            System.out.println(sum + out);
        }
    }
}
