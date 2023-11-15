package November_2023;

import java.util.Arrays;
/*
    给你一个下标从 0 开始的整数数组 nums 和一个整数 k. 你需要执行以下操作恰好 k 次, 最大化你的得分：
        从 nums 中选择一个元素 m.
        将选中的元素 m 从数组中删除.
        将新元素 m + 1 添加到数组中.
        你的得分增加 m.
    请你返回执行以上操作恰好 k 次后的最大得分.
 */
public class maximizeSum_2656 {
    public int maximizeSum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        while(k-- > 0){
            res += nums[n - 1];
            nums[n - 1]++;
        }
        return res;
    }
}
