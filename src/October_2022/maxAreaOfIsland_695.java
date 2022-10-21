package October_2022;

/*
    给你一个大小为 m x n 的二进制矩阵 grid.
    岛屿是由一些相邻的 1 (代表土地) 构成的组合， 这里的「相邻」要求两个 1 必须在水平或者竖直的四个方向上相邻.
    你可以假设 grid 的四个边缘都被 0(代表水)包围着.
    岛屿的面积是岛上值为 1 的单元格的数目.
    计算并返回 grid 中最大的岛屿面积. 如果没有岛屿, 则返回面积为 0.
 */
public class maxAreaOfIsland_695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    res = Math.max(dfs(grid, i, j), res);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        //防止重复 + 1
        grid[i][j] = 0;
        //初始面积为 1
        int count = 1;
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j + 1);
        count += dfs(grid, i, j - 1);
        return count;
    }
}
