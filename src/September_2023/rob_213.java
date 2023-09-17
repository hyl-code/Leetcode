package September_2023;

/*
    你是一个专业的小偷, 计划偷窃沿街的房屋, 每间房内都藏有一定的现金.
    这个地方所有的房屋都围成一圈, 这意味着第一个房屋和最后一个房屋是紧挨着的.
    同时, 相邻的房屋装有相互连通的防盗系统, 如果两间相邻的房屋在同一晚上被小偷闯入, 系统会自动报警.
    给定一个代表每个房屋存放金额的非负整数数组, 计算你在不触动警报装置的情况下, 今晚能够偷窃到的最高金额.
 */
public class rob_213 {
    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0] + helper(nums, 2, n - 1), helper(nums, 1, n));
    }

    // 引用 rob1 的代码
    private int helper(int[] nums, int start, int end){
        int f0 = 0, f1 = 0;
        for(int i = start; i < end; i++){
            int temp = Math.max(f1, f0 + nums[i]);
            f0 = f1;
            f1 = temp;
        }
        return f1;
    }
}
