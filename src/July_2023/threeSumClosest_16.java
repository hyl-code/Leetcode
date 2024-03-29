package July_2023;

import java.util.Arrays;
/*
    给你一个长度为 n 的整数数组 nums 和 一个目标值 target.
    请你从 nums 中选出三个整数, 使它们的和与 target 最接近.
    返回这三个数的和.
    假定每组输入只存在恰好一个解.
 */
public class threeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if(sum == target){
                    return target;
                }else if(sum > target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }
}
