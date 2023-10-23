package October_2023;

/*
    这里有 n 个一样的骰子, 每个骰子上都有 k 个面, 分别标号为 1 到 k.
    给定三个整数 n, k 和 target, 返回可能的方式（从总共 k^n 种方式中）滚动骰子的数量, 使正面朝上的数字之和等于 target.
    答案可能很大, 你需要对 10^9 + 7 取模.
 */
public class numRollsToTarget_1155 {
    static final int MOD = 1000000007;
    // 动态规划
    public int numRollsToTarget(int n, int k, int target) {
        int[][] f = new int[n + 1][target + 1];
        f[0][0] = 1;
        // f(i,j) 表示使用 i 个骰子且数字之和为 j 的方案数.
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= target; j++){
                for(int x = 1; x <= k; x++){
                    if(j - x >= 0){
                        f[i][j] = (f[i][j] + f[i - 1][j - x]) % MOD;
                    }
                }
            }
        }
        return f[n][target];
    }
}
