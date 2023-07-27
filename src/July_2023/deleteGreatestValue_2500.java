package July_2023;

import java.util.Arrays;
/*
    给你一个 m x n 大小的矩阵 grid, 由若干正整数组成.
    执行下述操作, 直到 grid 变为空矩阵：
        从每一行删除值最大的元素. 如果存在多个这样的值, 删除其中任何一个.
        将删除元素中的最大值与答案相加.
    注意：每执行一次操作, 矩阵中列的数据就会减 1.
    返回执行上述操作后的答案.
 */
public class deleteGreatestValue_2500 {
    public int deleteGreatestValue(int[][] grid) {
        for(int[] nums : grid){
            Arrays.sort(nums);
        }
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = n - 1; i >= 0; i--){
            int max = -1;
            for(int j = 0; j < m; j++){
                max = Math.max(grid[j][i], max);
            }
            res += max;
        }
        return res;
    }
}
