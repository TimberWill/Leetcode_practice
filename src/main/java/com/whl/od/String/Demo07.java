package com.whl.od.String;

import java.util.Scanner;

/**
 * @program: Hello-world
 * @description: 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 * 数据范围：保证输入的是合法的 IP 序列
 * @author: whl
 * @create: 2024-11-04 12:56
 **/
public class Demo07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String s1 = in.nextLine();
            String s2 = in.nextLine();

            String[] split1 = s1.split("\\.");
            long long2 = Long.parseLong(s2);

            //ip地址转数字
            StringBuilder builder1 = new StringBuilder();
            for (String s : split1) {
                String binaryString = Integer.toBinaryString(Integer.valueOf(s));
                String replace = String.format("%8s", binaryString).replace(' ', '0');
                builder1.append(replace);
            }
            long number = Long.parseLong(builder1.toString(), 2);//2进制转为十进制

            //数字转ip地址
            String binaryString = Long.toBinaryString(long2);
            String replace = String.format("%32s", binaryString).replace(' ', '0');
            StringBuilder builder2 = new StringBuilder();
            int ip1 = Integer.parseInt(replace.substring(0, 8), 2);
            int ip2 = Integer.parseInt(replace.substring(8, 16), 2);
            int ip3 = Integer.parseInt(replace.substring(16, 24), 2);
            int ip4 = Integer.parseInt(replace.substring(24, 32), 2);
            builder2.append(ip1).append(".").append(ip2).append(".").append(ip3).append(".").append(ip4);

            System.out.println(number);
            System.out.println(builder2.toString());
        }
    }
}
