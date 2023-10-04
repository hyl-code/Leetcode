package October_2023;

import java.util.Arrays;
/*
    给你一个整数数组 prices 和一个整数 k, 其中 prices[i] 是某支给定的股票在第 i 天的价格.
    设计一个算法来计算你所能获取的最大利润. 你最多可以完成 k 笔交易. 也就是说, 你最多可以买 k 次, 卖 k 次.
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）.
 */
public class maxProfit_188 {
    // 万能解法
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] f = new int[n + 1][k + 2][2];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < k + 2; j++){
                Arrays.fill(f[i][j], Integer.MIN_VALUE);
                f[0][j][0] = 0;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = k + 1; j > 0; j--){
                f[i + 1][j][0] = Math.max(f[i][j][0], f[i][j - 1][1] + prices[i]);
                f[i + 1][j][1] = Math.max(f[i][j][1], f[i][j][0] - prices[i]);
            }
        }
        return f[n][k + 1][0];
    }
}
