package com.whl.od.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @program: Hello-world
 * @description: 字符串合并处理
 * 按照指定规则对输入的字符串进行处理。
 * 详细描述：
 * 第一步：将输入的两个字符串str1和str2进行前后合并。如给定字符串 "dec" 和字符串 "fab" ， 合并后生成的字符串为 "decfab"
 * 第二步：对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标的意思是字符在字符串中的位置。
 * 注意排序后在新串中仍需要保持原来的奇偶性。例如刚刚得到的字符串“decfab”，分别对下标为偶数的字符'd'、'c'、'a'和
 * 下标为奇数的字符'e'、'f'、'b'进行排序（生成 'a'、'c'、'd' 和 'b' 、'e' 、'f'），再依次分别放回原串中的偶数位和奇数位，新字符串变为“abcedf”
 * 第三步：对排序后的字符串中的'0'~'9'、'A'~'F'和'a'~'f'字符，需要进行转换操作。
 * 转换规则如下：
 * 对以上需要进行转换的字符所代表的十六进制用二进制表示并倒序，然后再转换成对应的十六进制大写字符（注：字符 a~f 的十六进制对应十进制的10~15，大写同理）。
 * 如字符 '4'，其二进制为 0100 ，则翻转后为 0010 ，也就是 2 。转换后的字符为 '2'。
 * 如字符 ‘7’，其二进制为 0111 ，则翻转后为 1110 ，对应的十进制是14，转换为十六进制的大写字母为 'E'。
 * 如字符 'C'，代表的十进制是 12 ，其二进制为 1100 ，则翻转后为 0011，也就是3。转换后的字符是 '3'。
 * 根据这个转换规则，由第二步生成的字符串 “abcedf” 转换后会生成字符串 "5D37BF"。
 * 数据范围：输入的字符串长度满足1≤n≤100$
 * @author: whl
 * @create: 2024-10-29 14:20
 **/
public class Demo06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s1 = in.next();
            String s2 = in.next();
            //1. 合并字符串
            StringBuilder builder = new StringBuilder();
            builder.append(s1).append(s2);

            //2. 合并后的字符串排序
            char[] charArray = builder.toString().toCharArray();
            ArrayList<Character> even = new ArrayList<>();
            ArrayList<Character> odd = new ArrayList<>();
            //排序
            for (int i = 0; i < charArray.length; i++) {
                if (i % 2 == 0){
                    //偶数
                    even.add(charArray[i]);
                }else {
                    //奇数
                    odd.add(charArray[i]);
                }
            }
            Collections.sort(even);
            Collections.sort(odd);
            //重新组合
            for (int i = 0; i < charArray.length; i++) {
                if (i % 2 == 0){
                    //偶数
                    charArray[i] = even.get(i/2);
                }else {
                    //奇数
                    charArray[i] = odd.get(i/2);
                }
            }

            //3. 进行转换操作
            StringBuilder result = new StringBuilder();
            for (char c : charArray) {
                if ((c >= '0' && c <= '9')||(c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')){
                    //转化为十六进制的数字
                    int value;
                    if (c >= '0' && c <= '9'){
                        value = c - '0';
                    }else if (c >= 'a' && c <= 'f'){
                        value = c - 'a' + 10;
                    }else{
                        value = c - 'A' + 10;
                    }
                    //转为4位的二进制
                    String binaryString = String.format("%4s", Integer.toBinaryString(value)).replace(' ', '0');
                    //倒置二进制
                    String reverseBinaryString = new StringBuilder(binaryString).reverse().toString();
                    //转为十进制
                    int number = Integer.parseInt(reverseBinaryString, 2);
                    //如果>=10，转为十六进制
                    if (number >= 10){
                        char hd = (char) ('A' + number - 10);
                        result.append(hd);
                    }else {
                        result.append(number);
                    }
                }else {
                    result.append(c);
                }

            }
            System.out.println(result.toString());

        }
    }
}
