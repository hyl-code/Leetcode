package April_2023;

/*
    你有一个凸的 n 边形, 其每个顶点都有一个整数值.
    给定一个整数数组 values, 其中 values[i] 是第 i 个顶点的值 (即顺时针顺序).
    假设将多边形剖分为 n - 2 个三角形.
    对于每个三角形, 该三角形的值是顶点标记的乘积, 三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和.
    返回多边形进行三角剖分后可以得到的最低分.
 */
public class minScoreTriangulation_1039 {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for(int i = n - 3; i >= 0; i--){
            for(int j = i + 2; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i + 1; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
