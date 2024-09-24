package com.whl.od.String;

import java.util.*;

/**
 * @program: Hello-world
 * @description: 简单错误记录
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理：
 * 1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。对相同的错误记录只记录一条，但是错误计数增加。
 *     最后一个斜杠后面的带后缀名的部分（保留最后16位）和行号完全匹配的记录才做算是“相同”的错误记录。
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。也就是说，哪怕不同路径下的文件，如果它们的名字的后16个字符相同，也被视为相同的错误记录
 * 4、 循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
 * 数据范围：错误记录数量满足1≤n≤100  ，每条记录长度满足1≤len≤100
 * @author: whl
 * @create: 2024-09-24 11:38
 **/
public class Demo03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        while (in.hasNextLine()){
            String next = in.nextLine();
            String[] split1 = next.split(" ");
            String rowNumber = split1[1];

            String[] split2 = split1[0].split("\\\\");
            String fileName = split2[split2.length-1];//最后一个

            if (fileName.length() >16){
                fileName = fileName.substring(fileName.length() - 16);
            }
            String name = fileName + " " + rowNumber;

            int times = map.getOrDefault(name,0);
            if (times == 0){
                queue.add(name);
                if (queue.size() > 8){
                    queue.poll();
                }
                map.put(name,1);
            }else {
                map.put(name,times + 1);
            }
        }
        for (String s : queue) {
            System.out.println(s + " " + map.get(s));
        }

    }
}
