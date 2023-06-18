package June_2023;

/*
    二维矩阵 grid 由 0（土地）和 1（水）组成.
    岛是由最大的 4 个方向连通的 0 组成的群, 封闭岛是一个完全由 1 包围（左、上、右、下）的岛.
    请返回封闭岛屿的数目.
 */
public class closedIsland_1254 {
    public int closedIsland(int[][] grid) {
        int cnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    cnt = dfs(grid, i, j) ? cnt + 1 : cnt;
                }
            }
        }
        return cnt;
    }

    // DFS：深度优先搜索
    public boolean dfs(int[][] grid, int i, int j){
        //边界上的岛屿不算封闭岛屿.
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length){
            return false;
        }
        if(grid[i][j] == 0){
            grid[i][j] = 1;
            boolean up = dfs(grid, i + 1, j);
            boolean down = dfs(grid, i - 1, j);
            boolean left = dfs(grid, i, j - 1);
            boolean right = dfs(grid, i, j + 1);
            return (up && down && left && right);
        }
        return true;
    }
}
