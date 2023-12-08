package December_2023;

import java.util.*;
/*
    你驾驶出租车行驶在一条有 n 个地点的路上. 这 n 个地点从近到远编号为 1 到 n, 你想要从 1 开到 n, 通过接乘客订单盈利.
    你只能沿着编号递增的方向前进, 不能改变方向.
    乘客信息用一个下标从 0 开始的二维数组 rides 表示, 其中 rides[i] = [starti, endi, tipi] 表示第 i 位乘客
        需要从地点 starti 前往 endi, 愿意支付 tipi 元的小费.
    每一位 你选择接单的乘客 i, 你可以 盈利 endi - starti + tipi 元. 你同时最多只能接一个订单.
    给你 n 和 rides, 请你返回在最优接单方案下, 你能盈利最多多少元.
    注意：你可以在一个地点放下一位乘客, 并在同一个地点接上另一位乘客.
 */
public class maxTaxiEarnings_2008 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[n + 1];
        Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
        for(int[] ride : rides){
            map.putIfAbsent(ride[1], new ArrayList<int[]>());
            map.get(ride[1]).add(ride);
        }
        for(int i = 1; i <= n; i++){
            dp[i] = dp[i - 1];
            for(int[] ride : map.getOrDefault(i, new ArrayList<int[]>())){
                dp[i] = Math.max(dp[i], dp[ride[0]] + ride[1] - ride[0] + ride[2]);
            }
        }
        return dp[n];
    }
}
