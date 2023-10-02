package October_2023;

/*
    给你一个整数数组 prices, 其中 prices[i] 表示某支股票第 i 天的价格.
    在每一天, 你可以决定是否购买和/或出售股票.
    你在任何时候最多只能持有一股股票.
    你也可以先购买, 然后在同一天出售.
    返回你能获得的最大利润.
 */
public class maxProfit_122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n + 1][2];
        f[0][1] = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            f[i + 1][0] = Math.max(f[i][0], f[i][1] + prices[i]);
            f[i + 1][1] = Math.max(f[i][1], f[i][0] - prices[i]);
        }
        return f[n][0];
    }
}
