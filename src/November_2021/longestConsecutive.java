package November_2021;

import java.util.HashSet;
import java.util.Set;

/*
    给定一个未排序的整数数组 nums , 找出数字连续的最长序列(不要求序列元素在原数组中连续)的长度 .
    请你设计并实现时间复杂度为 O(n) 的算法解决此问题 .
 */

public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        Set<Integer> set = new HashSet<>();
        int res = 1, temp = 1;
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        for(int num : set){
            if (!set.contains(num - 1)) {
                int n = num;
                while (set.contains(n + 1)) {
                    n++;
                    temp++;
                }
                res = Math.max(res, temp);
                temp = 1;
            }
        }
        return res;
    }
}
