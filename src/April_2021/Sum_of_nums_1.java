package April_2021;

    //1.给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
      //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
      //你可以按任意顺序返回答案。

import java.util.HashMap;
import java.util.Map;

public class Sum_of_nums_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
