package December_2023;

/*
    一个 2D 网格中的峰值是指那些严格大于其相邻格子 (上、下、左、右) 的元素.
    给你一个 从 0 开始编号 的 m x n 矩阵 mat, 其中任意两个相邻格子的值都不相同.
    找出任意一个峰值 mat[i][j] 并返回其位置 [i,j].
    你可以假设整个矩阵周边环绕着一圈值为 -1 的格子.
    要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
 */
public class findPeakGrid_1901 {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int l = 0, r = m - 1;
        while(l <= r){
            int i = (l + r) / 2;
            int j = -1, maxElement = -1;
            for(int k = 0; k < n; k++){
                if(mat[i][k] > maxElement){
                    j = k;
                    maxElement = mat[i][k];
                }
            }
            if(i - 1 >= 0 && mat[i][j] < mat[i - 1][j]){
                r = i - 1;
                continue;
            }
            if(i + 1 < m && mat[i][j] < mat[i + 1][j]){
                l = i + 1;
                continue;
            }
            return new int[]{i, j};
        }
        return new int[0];
    }
}
