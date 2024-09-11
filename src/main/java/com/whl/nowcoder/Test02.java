package com.whl.nowcoder;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Hello-world
 * @description: 子串
 * @author: whl
 * @create: 2024-09-02 14:27
 **/
public class Test02 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "bbbbbb";
        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
    }
    public static int lengthOfLongestSubstring(String s) {
//        HashSet<Object> objects = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            objects.add(c);
//        }

        int slow = 0;
        int fast = slow;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (fast +1 <= s.length()){
                fast ++;
                if (s.charAt(slow) == (s.charAt(fast)-'0')){
                    slow = fast + 1;
                    fast = slow +1;
                    count = 0;
                }else {
                    fast ++ ;
                    if ((fast - slow +1) > count){
                        count = fast - slow +1;
                    }
                }
            }

        }


//        return objects.size();
        return count;
    }
}
