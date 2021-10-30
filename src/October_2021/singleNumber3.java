package October_2021;

import java.util.Arrays;

/*
    给定一个整数数组 nums, 其中恰好有两个元素只出现一次, 其余所有元素均出现两次 .
    找出只出现一次的那两个元素. 你可以按任意顺序返回答案 .
 */

public class singleNumber3 {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2)
            return nums;
        int[] res = new int[2];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                i++;
            }else if(i % 2 == 0){
                res[0] = nums[i];
            }else if(i % 2 != 0){
                res[1] = nums[i];
            }
            if(i == nums.length - 2){
                res[1] = nums[i+1];
            }
        }
        return res;
    }
}
