package February_2022;

/*
    给定一个按照升序排列的整数数组 nums, 和一个目标值 target.
    找出给定目标值在数组中的开始位置和结束位置 .
    如果数组中不存在目标值 target , 返回[-1, -1] .
 */

public class searchRange_34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[] {-1, -1};
        }
        int left = 0, right = nums.length - 1;
        while(left < right && (nums[left] != target || nums[right]!= target)){
            if(nums[left] < target && left < nums.length - 1){
                left++;
            }
            if(nums[right] > target && right > 0){
                right--;
            }
        }
        if(nums[left] != target){
            return new int[] {-1, -1};
        }
        return new int[] {left, right};
    }
}
