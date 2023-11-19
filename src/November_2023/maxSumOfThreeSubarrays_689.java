package November_2023;

/*
    给你一个整数数组 nums 和一个整数 k, 找出三个长度为 k 、互不重叠、且全部数字和（ 3 * k 项）最大的子数组, 并返回这三个子数组.
    以下标的数组形式返回结果, 数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）.
    如果有多个结果，返回字典序最小的一个.
 */
public class maxSumOfThreeSubarrays_689 {
    // 滑动窗口
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res = new int[3];
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum2 = 0, maxSum2Idx1 = 0, maxSum2Idx2 = 0;
        int sum3 = 0, maxTotal = 0;
        for(int i = k * 2; i < nums.length; i++){
            sum1 += nums[i - k * 2];
            sum2 += nums[i - k];
            sum3 += nums[i];
            if(i >= k * 3 - 1){
                if(sum1 > maxSum1){
                    maxSum1 = sum1;
                    maxSum1Idx = i - k * 3 + 1;
                }
                if(maxSum1 + sum2 > maxSum2){
                    maxSum2 = maxSum1 + sum2;
                    maxSum2Idx1 = maxSum1Idx;
                    maxSum2Idx2 = i - k * 2 + 1;
                }
                if(maxSum2 + sum3 > maxTotal){
                    maxTotal = maxSum2 + sum3;
                    res[0] = maxSum2Idx1;
                    res[1] = maxSum2Idx2;
                    res[2] = i - k + 1;
                }
                sum1 -= nums[i - k * 3 + 1];
                sum2 -= nums[i - k * 2 + 1];
                sum3 -= nums[i - k + 1];
            }
        }
        return res;
    }

    // 前缀和 + 动态规划
    public int[] maxSumOfThreeSubarrays2(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        long[][] f = new long[n + 10][4];
        for(int i = n - k + 1; i >= 1; i--){
            for(int j = 1; j < 4; j++){
                f[i][j] = Math.max(f[i + 1][j], f[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]);
            }
        }
        int[] res = new int[3];
        int i = 1, j = 3, idx = 0;
        while(j > 0){
            if(f[i + 1][j] > f[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]){
                i++;
            }else{
                res[idx++] = i - 1;
                i += k;
                j--;
            }
        }
        return res;
    }
}
