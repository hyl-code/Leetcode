package October_2023;

/*
    给定一个数组 prices, 它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格.
    你只能选择某一天买入这只股票, 并选择在未来的某一个不同的日子卖出该股票.
    设计一个算法来计算你所能获取的最大利润.
    返回你可以从这笔交易中获取的最大利润. 如果你不能获取任何利润, 返回 0.
 */
public class maxProfit_121 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);         // 维护最小值
            max = Math.max(max, prices[i] - min);   // 维护最大值
        }
        return max;
    }
}
