package October_2023;

/*
    给定一个整数数组 prices, 其中第 prices[i] 表示第 i 天的股票价格.
    设计一个算法计算出最大利润. 在满足以下约束条件下, 你可以尽可能地完成更多的交易（多次买卖一支股票）：
        卖出股票后, 你无法在第二天买入股票（即冷冻期为 1 天）.
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）.
 */
public class maxProfit_309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n + 2][2];
        f[1][1] = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            f[i + 2][0] = Math.max(f[i + 1][0], f[i + 1][1] + prices[i]);
            f[i + 2][1] = Math.max(f[i + 1][1], f[i][0] - prices[i]);
        }
        return f[n + 1][0];
    }
}
