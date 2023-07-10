package July_2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
    给你一个整数数组 nums, 判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k,
    同时还满足 nums[i] + nums[j] + nums[k] == 0.
    请你返回所有和为 0 且不重复的三元组.
    注意：答案中不可以包含重复的三元组.
 */
public class threeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return res;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}
