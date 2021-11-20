package November_2021;

import java.util.Arrays;
import java.util.HashMap;

/*
    和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是 1 .
    现在, 给你一个整数数组 nums , 请你在所有可能的子序列中找到最长的和谐子序列的长度 .
    数组的子序列是一个由数组派生出来的序列, 它可以通过删除一些元素或不删除元素, 且不改变其余元素的顺序而得到 .
 */

public class findLHS_594 {
    public int findLHS(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()){
            int x = map.get(key);
            if(map.containsKey(key + 1))
                res = Math.max(res, x + map.get(key + 1));
        }
        return res;
    }

    //排序 + 双指针
    public int findLHS2(int[] nums) {
        Arrays.sort(nums);
        int left = 0, res = 0;
        for(int right = 0; right < nums.length; right++){
            while(nums[right] - nums[left] > 1){
                left++;
            }
            if(nums[right] - nums[left] == 1)
                res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
