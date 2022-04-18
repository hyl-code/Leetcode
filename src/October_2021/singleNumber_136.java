package October_2021;

import java.util.Arrays;

/*
    给定一个非空整数数组, 除了某个元素只出现一次以外, 其余每个元素均出现两次 .
    找出那个只出现了一次的元素 .
 */

public class singleNumber_136 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 1; i += 2){
            if(nums[i] != nums[i+1])
                return nums[i];
        }
        return nums[nums.length - 1];
    }

    //位运算
    public int singleNumber1(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
