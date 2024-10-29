package com.whl;

/**
 * @program: Hello-world
 * @description:
 * @author: whl
 * @create: 2024-10-29 15:12
 **/
public class Test {
    public static void main(String[] args) {
        int i = 2;
        String binaryString = Integer.toBinaryString(i);
        System.out.println(String.format("%4s", binaryString).replace(' ','0'));


        System.out.println(Integer.parseInt("0010",2));
    }
}
