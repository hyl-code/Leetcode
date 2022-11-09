package November_2022;

/*
    在一个 n x n 的矩阵 grid 中, 除了在数组 mines 中给出的元素为 0, 其他每个元素都为 1.
    mines[i] = [xi, yi]表示 grid[xi][yi] == 0
    返回 grid 中包含 1 的最大的轴对齐加号标志的阶数. 如果未找到加号标志, 则返回 0.
    一个 k 阶由 1 组成的 “轴对称” 加号标志具有中心网格 grid[r][c] == 1,
    以及4个从中心向上、向下、向左、向右延伸, 长度为 k-1, 由 1 组成的臂.
    注意, 只有加号标志的所有网格要求为 1, 别的网格可能为 0 也可能为 1.
 */
public class orderOfLargestPlusSign_764 {
    //暴力
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        boolean[][] grid = new boolean[n][n];
        int res = 0;
        for(int[] m : mines){
            grid[m[0]][m[1]] = true;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!grid[i][j]){
                    int max = getPlusSign(grid, i, j);
                    res = Math.max(res, max);
                }
            }
        }
        return res;
    }

    public int getPlusSign(boolean[][] grid, int x, int y){
        int num = 0;
        while(x - num >= 0 && x + num < grid.length && y - num >= 0 && y + num < grid[0].length &&
                !(grid[x - num][y] || grid[x + num][y] || grid[x][y - num] || grid[x][y + num])){
            num++;
        }
        return num;
    }
}
