package com.whl.leetcode;

import java.util.*;

/**
 * 作者：whl
 * 日期：2023-02-07 13:31
 * 描述：1604. 警告一小时内使用相同员工卡大于等于三次的人
 * 力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告 。
 *
 * 给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时间。
 *
 * 使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。
 *
 * 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。
 *
 * 请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情况。
 */
public class Day1 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> hash = new HashMap<>();
        List<String> result = new ArrayList<>();
        int a = keyName.length;

        for (int i = 0; i < a; i++) {
            hash.putIfAbsent(keyName[i],new ArrayList<Integer>());
            //string 转 int
            String h = keyTime[i].substring(0, keyTime[i].indexOf(":"));
            String min = keyTime[i].substring(h.length() + 1, keyTime[i].length());
            int h_i = Integer.parseInt(h);
            int m_i = Integer.parseInt(min);
            int time = h_i*60 + m_i;
            //存入hash
            hash.get(keyName[i]).add(time);
        }
        //获取各个员工的打卡记录时间
        for (String s : hash.keySet()) {
            List<Integer> times = hash.get(s);
            //对时间排序-升序
            Collections.sort(times);
            //每三个进行比较
            for (int i = 2; i < times.size(); i++) {
                int o = times.get(i) - times.get(i-2);
                if (o <= 60){
                    if (!result.contains(s)){
                        result.add(s);
                    }
                }
            }
        }
        Collections.sort(result);

        return result;
    }
}
