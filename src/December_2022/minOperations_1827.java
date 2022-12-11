package December_2022;

/*
    给你一个整数数组 nums (下标从 0 开始). 每一次操作中, 你可以选择数组中一个元素, 并将它增加 1.
    比方说, 如果 nums = [1,2,3], 你可以选择增加 nums[1] 得到 nums = [1,3,3].
    请你返回使 nums 严格递增的最少操作次数.
    我们称数组 nums 是严格递增的, 当它满足对于所有的 0 <= i < nums.length - 1 都有 nums[i] < nums[i+1].
    一个长度为 1 的数组是严格递增的一种特殊情况.
 */
public class minOperations_1827 {
    public int minOperations(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int res = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] >= nums[i + 1]){
                res += (nums[i] - nums[i + 1] + 1);
                nums[i + 1] = nums[i] + 1;
            }
        }
        return res;
    }
}
