package November_2023;

/*
    给你一个下标从 0 开始的整数数组 nums 和一个整数 threshold.
    请你从 nums 的子数组中找出以下标 l 开头、下标 r 结尾 (0 <= l <= r < nums.length) 且满足以下条件的最长子数组：
        nums[l] % 2 == 0
        对于范围 [l, r - 1] 内的所有下标 i, nums[i] % 2 != nums[i + 1] % 2
        对于范围 [l, r] 内的所有下标 i ，nums[i] <= threshold
    以整数形式返回满足题目要求的最长子数组的长度.
    注意：子数组是数组中的一个连续非空元素序列.
 */
public class longestAlternatingSubarray_2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int res = 0, i = 0;
        while(i < n){
            if(nums[i] > threshold || nums[i] % 2 != 0){
                i++;
                continue;
            }
            int l = i;
            i++;
            while(i < n && nums[i] <= threshold && nums[i] % 2 != nums[i - 1] % 2){
                i++;
            }
            res = Math.max(res, i - l);
        }
        return res;
    }
}
