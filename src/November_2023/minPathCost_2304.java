package November_2023;

/*
    给你一个下标从 0 开始的整数矩阵 grid, 矩阵大小为 m x n, 由从 0 到 m * n - 1 的不同整数组成.
    你可以在此矩阵中, 从一个单元格移动到下一行的任何其他单元格.
    如果你位于单元格 (x, y), 且满足 x < m - 1, 你可以移动到 (x + 1, 0), (x + 1, 1), ..., (x + 1, n - 1) 中的任何一个单元格.
    注意： 在最后一行中的单元格不能触发移动.
    每次可能的移动都需要付出对应的代价, 代价用一个下标从 0 开始的二维数组 moveCost 表示, 该数组大小为 (m * n) x n,
        其中 moveCost[i][j] 是从值为 i 的单元格移动到下一行第 j 列单元格的代价.
    从 grid 最后一行的单元格移动的代价可以忽略.
    grid 一条路径的代价是：所有路径经过的单元格的值之和加上所有移动的代价之和。
    从第一行任意单元格出发, 返回到达最后一行任意单元格的最小路径代价.
 */
public class minPathCost_2304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1] = grid[m - 1];
        for(int i = m - 2; i >= 0; i--){
            for(int j = 0; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][k] + moveCost[grid[i][j]][k]);
                }
                dp[i][j] += grid[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int num : dp[0]){
            res = Math.min(num, res);
        }
        return res;
    }
}
