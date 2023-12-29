package December_2023;

import java.util.Arrays;
/*
    给你一个整数数组 prices, 它表示一个商店里若干巧克力的价格. 同时给你一个整数 money, 表示你一开始拥有的钱数.
    你必须购买恰好两块巧克力, 而且剩余的钱数必须是非负数. 同时你想最小化购买两块巧克力的总花费.
    请你返回在购买两块巧克力后, 最多能剩下多少钱. 如果购买任意两块巧克力都超过了你拥有的钱, 请你返回 money.
    注意剩余钱数必须是非负数.
 */
public class buyChoco_2706 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        return prices[0] + prices[1] > money ? money : money - (prices[0] + prices[1]);
    }
}
