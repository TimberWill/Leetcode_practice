package com.whl.od.String;

import java.util.Scanner;

/**
 * @program: Hello-world
 * @description: 判断两个ip地址是否属于同一个子网
 * @author: whl
 * @create: 2024-11-21 10:59
 **/
public class Demo08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] split1 = in.next().split("\\.");
            String[] split2 = in.next().split("\\.");
            String[] split3 = in.next().split("\\.");

            //1.  判断范围合法性
            if (!isIllegal(split1) || !isIllegal(split2) || !isIllegal(split3)){
                System.out.println(1);
            }else {
                //2. 转为二进制
                String binary1 = toBinary(split1);
                String binary2 = toBinary(split2);
                String binary3 = toBinary(split3);
                //2.1 验证掩码的二进制是否合法
                if (!isBinaryIllegal(binary1)){
                    System.out.println(1);
                }else {
                    //3. AND运算
                    String s1 = bitAND(binary1, binary2);
                    String s2 = bitAND(binary1, binary3);

                    //4. 比较值
                    if (s1.equals(s2)){
                        System.out.println(0);
                    }else {
                        System.out.println(2);
                    }
                }
            }
        }
    }

    public static boolean isIllegal(String[] split){
        for (String s : split) {
            int value = Integer.parseInt(s);
            if (value < 0 || value > 255){
                return false;
            }
        }

        return true;
    }

    public static String toBinary(String[] sList){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < sList.length; i++) {
            int value = Integer.parseInt(sList[i]);

            String binaryString = Integer.toBinaryString(value);
            String replace = String.format("%8s", binaryString).replace(' ', '0');

            if (i == sList.length - 1){
                builder.append(replace);
            }else {
                builder.append(replace).append(".");
            }
        }

        return builder.toString();
    }

    public static boolean isBinaryIllegal(String binary){
        String replace = binary.replace(".", "");
        char[] charArray = replace.toCharArray();

        boolean flag = false;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0'){
                flag = true;//遇到了0
            }else {
                //遇到0了之后又遇到1
                if (charArray[i] == '1' && flag){
                    return false;
                }
            }
        }
        return true;
    }

    public static String bitAND(String a, String b){
        String[] aSplit = a.split("\\.");
        String[] bSplit = b.split("\\.");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < aSplit.length; i++) {
            for (int j = 0; j < aSplit[i].length(); j++) {
                char re = aSplit[i].charAt(j) == '1' && bSplit[i].charAt(j) == '1' ? '1':'0';
                result.append(re);
            }
            result.append('.');
        }
        return result.toString();
    }

}
