package November_2022;

/*
    给定数组 nums 和一个整数 k. 我们将给定的数组 nums 分成最多 k 个相邻的非空子数组.
    分数由每个子数组内的平均值的总和构成.
    注意: 我们必须使用 nums 数组中的每一个数进行分组, 并且分数不一定需要是整数.
    返回我们所能得到的最大分数是多少. 答案误差在 10^(-6)内被视为是正确的.
 */
public class largestSumOfAverages_813 {
    double negInf = -1e7;
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] preSum = new double[n + 1];
        double[][] res = new double[n + 1][k + 1];//res[i][j] 表示的是前 i 项分成 j 组的最大平均和
        for(int i = 1; i <=n; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
            res[i][0] = negInf;
            for(int j = 1; j <= k; j++){
                for(int p = 0; p < i; p++){
                    res[i][j] = Math.max(res[i][j], res[p][j - 1] + (preSum[i] - preSum[p])/(i - p));
                }
            }
        }
        return res[n][k];
    }
}
