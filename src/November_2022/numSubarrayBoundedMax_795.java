package November_2022;

/*
    给你一个整数数组 nums 和两个整数: left 及 right.
    找出 nums 中连续, 非空且其中最大元素在范围 [left, right] 内的子数组, 并返回满足条件的子数组的个数.
    生成的测试用例保证结果符合 32-bit 整数范围.
 */
public class numSubarrayBoundedMax_795 {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        //Max >= left && Max <= right 的子数组个数 = Max <= right 的子数组个数 - Max < left 的子数组个数
        return subarrayboundedMax(nums, right) - subarrayboundedMax(nums, left - 1);
    }

    public int subarrayboundedMax(int[] nums, int max){
        int res = 0;
        int numSubarry = 0;
        for(int num : nums){
            //当 num <= max 时, numSubarray 表示含有 num 且范围为 [nums[0], num] 的子数组的个数
            if(num <= max){
                numSubarry++;
                res += numSubarry;
            }else{
                numSubarry = 0;
            }
        }
        return res;
    }
}
