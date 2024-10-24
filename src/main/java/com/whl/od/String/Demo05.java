package com.whl.od.String;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Hello-world
 * @description: 对输入的字符串进行加解密，并输出。
 * 加密方法为：
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 * 其他字符不做变化。
 * 解密方法为加密的逆过程。
 * 数据范围：输入的两个字符串长度满足1 ≤ n ≤ 1000，保证输入的字符串都是只由大小写字母或者数字组成
 * @author: whl
 * @create: 2024-10-24 10:27
 **/
public class Demo05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            //加密过程
            char[] array1 = s1.toCharArray();
            for (int i = 0; i < array1.length; i++) {
                if (Character.isLetter(array1[i])){
                    if (Character.isUpperCase(array1[i])){
                        char lowerCase = Character.toLowerCase(array1[i]);
                        if (array1[i] < 'Z'){
                            array1[i] = (char)(lowerCase + 1);
                        }else {
                            array1[i] = 'a';
                        }

                    }else if (Character.isLowerCase(array1[i])){
                        char upperCase = Character.toUpperCase(array1[i]);
                        if (array1[i] < 'z'){
                            array1[i] = (char) (upperCase + 1);
                        }else {
                            array1[i] = 'A';
                        }
                    }
                }else if (Character.isDigit(array1[i])){
                    int numericValue = (Character.getNumericValue(array1[i]) + 1)% 10;
                    //转为十进制数字
                    array1[i] = Character.forDigit(numericValue, 10);
                }
            }

            //解密过程
            char[] array2 = s2.toCharArray();
            for (int i = 0; i < array2.length; i++) {
                if (Character.isLetter(array2[i])){
                    if (Character.isUpperCase(array2[i])){
                        char lowerCase = Character.toLowerCase(array2[i]);
                        if (array2[i] > 'A'){
                            array2[i] = (char)(lowerCase - 1);
                        }else {
                            array2[i] = 'z';
                        }

                    }else if (Character.isLowerCase(array2[i])){
                        char upperCase = Character.toUpperCase(array2[i]);
                        if (array2[i] > 'a'){
                            array2[i] = (char) (upperCase - 1);
                        }else {
                            array2[i] = 'Z';
                        }
                    }
                }else if (Character.isDigit(array2[i])){
                    int numericValue = (Character.getNumericValue(array2[i]) - 1);
                    if (numericValue < 0){
                        numericValue = 9;
                    }
                    //转为十进制数字
                    array2[i] = Character.forDigit(numericValue, 10);
                }
            }

            System.out.println(String.valueOf(array1));
            System.out.println(String.valueOf(array2));

        }
    }
}
