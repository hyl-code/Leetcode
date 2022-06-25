package June_2022;

/*
    假如有一排房子, 共 n 个, 每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种,
    你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同 .

    当然, 因为市场上不同颜色油漆的价格不同, 所以房子粉刷成不同颜色的花费成本也是不同的.
    每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的 .
    例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费; costs[1][2] 表示第 1 号房子粉刷成绿色的花费, 以此类推 .

 */

public class minCost_091 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] res = new int[n + 1][3];
        for(int i = 1; i <= n; i++){
            res[i][0] = Math.min(res[i - 1][1], res[i - 1][2]) + costs[i - 1][0];
            res[i][1] = Math.min(res[i - 1][0], res[i - 1][2]) + costs[i - 1][1];
            res[i][2] = Math.min(res[i - 1][0], res[i - 1][1]) + costs[i - 1][2];
        }
        return Math.min(Math.min(res[n][0], res[n][1]), res[n][2]);
    }
}
