package October_2022;

/*
    你是一个专业的小偷, 计划偷窃沿街的房屋.
    每间房内都藏有一定的现金, 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统,
    如果两间相邻的房屋在同一晚上被小偷闯入, 系统会自动报警.
    给定一个代表每个房屋存放金额的非负整数数组, 计算你不触动警报装置的情况下, 一夜之内能够偷窃到的最高金额.
 */
public class rob_198 {
    //记忆化搜索
    public int rob(int[] nums) {
        int n = nums.length;
        //记忆数组
        int[] memo = new int[n];
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            //f(n)表示抢劫 [1, ... , n]可以得到的最高金额
            memo[i] = Math.max(nums[i] + memo[i - 2], memo[i - 1]);
        }
        return memo[n - 1];
    }

    //动态规划的空间优化
    public int rob2(int[] nums) {
        int pre = 0;
        int cur = 0;
        //f(n)的值只与 f(n - 1) 和 f(n - 2)相关
        for(int num : nums){
            int temp = Math.max(pre + num, cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}
