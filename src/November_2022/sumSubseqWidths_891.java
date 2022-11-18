package November_2022;

import java.util.Arrays;

/*
    一个序列的宽度定义为该序列中最大元素和最小元素的差值.
    给你一个整数数组 nums, 返回 nums 的所有非空子序列的宽度之和.
    由于答案可能非常大, 请返回对 109 + 7 取余后的结果.
    子序列定义为从一个数组里删除一些(或者不删除)元素, 但不改变剩下元素的顺序得到的数组.
    例如, [3,6,2,7] 就是数组 [0,3,1,6,2,2,7] 的一个子序列.
 */
public class sumSubseqWidths_891 {
    private static int MOD = 1000000007;
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long res = 0;
        long[] pow2 = new long[n];
        pow2[0] = 1;
        for(int i = 1; i < n; i++){
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }
        // nums[i] 对 res 的贡献为 [2^i - 2^(n - i - 1)] * nums[i]
        //子序列不要求连续且只需注意最大最小值  -> 元素排序后不影响结果
        for(int i = 0; i < n; i++){
            res += (pow2[i] - pow2[n - i - 1]) * nums[i];
        }
        return (int)(res % MOD + MOD) % MOD;
    }
}
