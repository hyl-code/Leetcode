package July_2021;

//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
//
//不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。


public class RemoveDuplicates_26 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 1){
            return nums.length;
        }

        int i = 0, j = 1;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            }else{
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i+1;
    }
}