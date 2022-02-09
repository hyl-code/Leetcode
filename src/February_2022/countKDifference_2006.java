package February_2022;

/*
    给你一个整数数组 nums 和一个整数 k, 请你返回数对(i, j)的数目,
    满足 i < j 且 |nums[i] - nums[j]| == k.
    |x|的值定义为:
    如果 x >= 0, 那么值为x.
    如果 x < 0, 那么值为-x.
 */

import java.util.HashMap;
import java.util.Map;

public class countKDifference_2006 {
    //暴力解法
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(Math.abs(nums[i] - nums[j]) == k){
                    res++;
                }
            }
        }
        return res;
    }

    // Hashmap
    public int countKDifference2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num : nums){
            if(map.containsKey(num + k)){
                res += map.get(num + k);
            }
            if(map.containsKey(num - k)){
                res += map.get(num - k);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}
