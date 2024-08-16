package com.whl.leetcode;

/**
 * @program: Hello-world
 * @description: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 **/
public class Demo03 {

    //方法1：
    public int removeDuplicates(int[] nums) {
        int oldLen = nums.length;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < oldLen; j++) {
                if (nums[i] == nums[j]){
                    count ++;
                    if (count >= 2){
                        for (int k = j; k < oldLen-1; k++) {
                            nums[k] = nums[k+1];
                        }
                        oldLen--;
                        j--;
                    }
                }else {
                    i = j-1;
                    count = 0;
                    break;
                }

            }

        }
        return oldLen;
    }


    //方法3：快慢指针
    //      slow指针保证数组元素不重复超过2个，fast指针用于判断，slow指针判断与前两位的元素是否相同
    public int removeDuplicates3(int[] nums){
        int n = nums.length;
        if (n <= 2){
            return n;
        }

        int slow = 2;
        int fast = 2;
        while (fast < n){
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


}
