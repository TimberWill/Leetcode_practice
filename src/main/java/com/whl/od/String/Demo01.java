package com.whl.od.String;

import java.util.Scanner;

/**
 * @program: Hello-world
 * @description: 字符串-坐标移动
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * 输入：  合法坐标为A(或者D或者W或者S) + 数字（两位以内）  坐标之间以;分隔。  非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * 下面是一个简单的例子 如：  A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 处理过程：  起点（0,0）  +   A10   =  （-10,0）  +   S20   =  (-10,-20)  +   W10  =  (-10,-10)  +   D30
 *       =  (20,-10)  +   x    =  无效  +   A1A   =  无效  +   B10A11   =  无效  +  一个空 不影响  +   A10  =  (10,-10)  结果 （10， -10）
 *
 * @author: whl
 * @create: 2024-09-15 19:33
 **/
public class Demo01 {
    //优化后
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String next = in.next();
        if (next.isEmpty() || next.length()>10000){
            return;
        }
        //分割next
        String[] split = next.split(";");
        int x = 0;
        int y = 0;
        here:
        for (String s : split) {
            if (!s.matches("[WASD][0-9]{1,2}")){
                continue here;
            }

            int control = Integer.parseInt(s.substring(1));

            switch (s.charAt(0)){
                case 'A':
                    x -= control;
                    break;
                case 'S':
                    y -= control;
                    break;
                case 'D':
                    x += control;
                    break;
                case 'W':
                    y += control;
                    break;
                default:
                    break;
            }
        }
        System.out.println(x+","+y);
    }

    //优化前
    public static void method(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String next = in.next();
        if (next.isEmpty() || next.length()>10000){
            return;
        }
        //分割next
        String[] split = next.split(";");
        int x = 0;
        int y = 0;
        here:
        for (String s : split) {
            StringBuilder tmp = new StringBuilder();
            if(s.isEmpty() || s.length() == 1){
                continue here;
            }
            String num = s.substring(1);


            char[] numArray = num.toCharArray();
            for (char c : numArray) {
                if (c - '0' > 10 || c - '0' < 0) {
                    continue here;
                }
                tmp.append(c - '0');
            }

            int control = Integer.parseInt(tmp.toString());

            switch (s.charAt(0)){
                case 'A':
                    x -= control;
                    break;
                case 'S':
                    y -= control;
                    break;
                case 'D':
                    x += control;
                    break;
                case 'W':
                    y += control;
                    break;
                default:
                    break;
            }
        }
        System.out.println(x+","+y);

    }
}
