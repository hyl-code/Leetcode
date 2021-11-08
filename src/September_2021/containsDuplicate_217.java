package September_2021;

import java.util.Arrays;

/*
    给定一个整数数组, 判断是否存在重复元素.

    如果存在一值在数组中出现至少两次, 函数返回 true. 如果数组中每个元素都不相同, 则返回 false .
*/

public class containsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2)
            return false;
        int i = 0;
        Arrays.sort(nums);
        while(i < nums.length - 1 && nums[i] != nums[i+1]){
            i++;
        }
        if(i == nums.length - 1)
            return false;
        else
            return true;
    }
}
