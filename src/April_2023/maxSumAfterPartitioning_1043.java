package April_2023;

/*
    给你一个整数数组 arr, 请你将该数组分隔为长度最多为 k 的一些 (连续) 子数组.
    分隔完成后, 每个子数组的中的所有值都会变为该子数组中的最大值.
    返回将数组分隔变换后能够得到的元素最大和.
    本题所用到的测试用例会确保答案是一个 32 位整数.
 */
public class maxSumAfterPartitioning_1043 {
    //动态规划 + 记忆化搜索 (递推)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for(int i = 0; i < n; i++){
            int max = -1;
            for(int j = i; j > (i - k) && j >= 0; j--){
                max = Math.max(max, arr[j]);
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + max * (i - j + 1));
            }
        }
        return dp[n];
    }
}
