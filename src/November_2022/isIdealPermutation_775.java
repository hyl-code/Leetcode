package November_2022;

/*
    给你一个长度为 n 的整数数组 nums, 表示由范围 [0, n - 1] 内所有整数组成的一个排列.
    全局倒置的数目等于满足下述条件不同下标对 (i, j) 的数目:
        0 <= i < j < n
        nums[i] > nums[j]
    局部倒置的数目等于满足下述条件的下标 i 的数目:
        0 <= i < n - 1
        nums[i] > nums[i + 1]
    当数组 nums 中全局倒置的数量等于局部倒置的数量时, 返回 true; 否则, 返回 false.
 */
public class isIdealPermutation_775 {
    public boolean isIdealPermutation(int[] nums) {
        int n =nums.length, suffix = nums[n - 1];
        for(int i = n - 3; i >= 0; i--){
            if(nums[i] > suffix){
                return false;
            }
            suffix = Math.min(suffix, nums[i + 1]);
        }
        return true;
    }
}
