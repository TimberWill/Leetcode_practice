package com.whl.od.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: Hello-world
 * @description: 密码验证合格程序
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 * 数据范围：输入的字符串长度满足1≤n≤100
 * @author: whl
 * @create: 2024-09-18 17:29
 **/
public class Demo01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String next = in.next();

            if (next.length() < 8 || next.length() > 100){
                //1. 长度检查
                System.out.println("NG");
                return;
            }else if (repeatSubstring(next)){
                //2. 子串检查
                System.out.println("NG");
            }else if (getStrings(next).size() < 3){
                //3. 大小写字母、数字、其他字符
                System.out.println("NG");
            }else {
                System.out.println("OK");
            }

        }
    }
    private static HashSet<String> getStrings(String next) {
        HashSet<String> hashSet = new HashSet<>();
        char[] charArray = next.toCharArray();
        for (char k : charArray) {
            if (Character.isUpperCase(k)){
                //大写字母
                hashSet.add("uppercase");
            }else if (Character.isLowerCase(k)){
                //小写
                hashSet.add("lowercase");
            } else if (Character.isDigit(k)){
                //数字
                hashSet.add("number");
            }else {
                //其他字符
                hashSet.add("others");
            }
        }
        return hashSet;
    }

    //子串重复计算
    private static boolean repeatSubstring(String str){
        char[] charArray = str.toCharArray();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length-2; i++) {
            for (int j = i+2; j < charArray.length; j++) {
                String s = str.substring(i, j + 1);
                int times = map.getOrDefault(s,0) + 1;
                map.put(s,times);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1){
                return true;
            }
        }
        return false;
    }
}
