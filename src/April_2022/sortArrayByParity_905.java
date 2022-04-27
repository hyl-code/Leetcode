package April_2022;

/*
    给你一个整数数组 nums, 将 nums 中的的所有偶数元素移动到数组的前面, 后跟所有奇数元素 .
    返回满足此条件的 任一数组 作为答案 .
 */

public class sortArrayByParity_905 {
    //双指针
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length == 1 && nums == null)
            return nums;
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        for(int num : nums){
            if(num % 2 == 1){
                res[right--] = num;
            }else{
                res[left++] = num;
            }
        }
        return res;
    }
}
