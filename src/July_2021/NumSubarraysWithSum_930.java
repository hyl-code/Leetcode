package July_2021;

import java.util.HashMap;
import java.util.Map;

//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空子数组。
//
//子数组 是数组的一段连续部分。

public class NumSubarraysWithSum_930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        //  需要预存前缀和为0的情况 否则会漏掉前几位都满足的情况
        map.put(0,1);
        int sum = 0;
        int times = 0;

        // 也可以用for each
      //for(int i : nums)
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            // 当前前缀和已知 判断是否含有 sum - goal 的前缀和 即可知道某一区间的和为 goal
            if(map.containsKey(sum - goal)){
                times += map.get(sum - goal); // 获取次数
            }
            // 更新
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return times;
    }
}
