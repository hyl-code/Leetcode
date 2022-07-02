package July_2022;

/*
    给你一个 m * n 的矩阵 grid, 矩阵中的元素无论是按行还是按列, 都以非递增顺序排列 .
    请你统计并返回 grid 中负数的数目 .
 */

public class countNegatives_1351 {
    //二分法
    public int countNegatives(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            int left = 0, right = grid[0].length - 1;
            while(left < right){
                int mid = left + (right - left) / 2;
                if(grid[i][mid] >= 0){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            if(grid[i][left] < 0){
                res += grid[0].length - left;
            }
        }
        return res;
    }

    public int countNegatives2(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            //从列遍历直到找到负数
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] < 0){
                    res += grid[0].length - j;
                    break;
                }
            }
        }
        return res;
    }
}
