package November_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
    给你一个包含 n 个整数的数组 nums, 判断 nums 中是否存在三个元素 a, b, c ,
    使得 a + b + c = 0 ?请你找出所有和为 0 且不重复的三元组 .
    注意: 答案中不可以包含重复的三元组 .
 */

public class threeSum_15 {
    //双指针法
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
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
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while(right > left && nums[right] == nums[right - 1])
                        right--;
                    while(right > left && nums[left] == nums[left + 1])
                        left++;
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}
