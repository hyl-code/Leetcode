package October_2023;

import java.util.Arrays;
/*
    给定一个数组, 它的第 i 个元素是一支给定的股票在第 i 天的价格.
    设计一个算法来计算你所能获取的最大利润. 你最多可以完成两笔交易.
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）.
 */
public class maxProfit_123 {
    // 递推
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] f = new int[n + 1][4][2];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 4; j++){
                Arrays.fill(f[i][j], Integer.MIN_VALUE);
                f[0][j][0] = 0;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 3; j > 0; j--){
                f[i + 1][j][0] = Math.max(f[i][j][0], f[i][j - 1][1] + prices[i]);
                f[i + 1][j][1] = Math.max(f[i][j][1], f[i][j][0] - prices[i]);
            }
        }
        return f[n][3][0];
    }
}
