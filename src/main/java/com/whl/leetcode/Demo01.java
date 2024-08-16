package com.whl.leetcode;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Hello-world
 * @description:
 *      给你一个仅由小写英文字母组成的字符串 s 。
 * 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。
 * 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。
 * 子字符串 是字符串中的一个连续 非空 字符序列。
 * @author: whl
 * @create: 2024-05-29 10:05
 **/
public class Demo01 {

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(maximumLength(s));
    }

    //双指针解法，至少相邻两个字符要相同，然后更新对应的key-value，否则往后查看，最后选择value>=3的，比较长度
    public static int maximumLength(String s) {
        if (s.length() < 3 || s.length() > 50){
            return -1;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j < s.length() && s.charAt(i) == s.charAt(j)){
                    String key = s.substring(i,j+1);
                    //getOrDefault(key,default)，存在key就获取对应的value，不存在就将该key的value设置为0
                    int times = map.getOrDefault(key, 0) + 1;
                    map.put(key, times);
                }else {
                    break;
                }

            }
        }
        int result = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 3){
                int length = entry.getKey().length();
                if (result < length){
                    result = length;
                }
            }
        }

        return  result;
    }
}
