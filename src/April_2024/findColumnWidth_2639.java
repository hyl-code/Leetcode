package April_2024;

/*
    给你一个下标从 0 开始的 m x n 整数矩阵 grid. 矩阵中某一列的宽度是这一列数字的最大字符串长度.
        比方说，如果 grid = [[-10], [3], [12]] ，那么唯一一列的宽度是 3 ，因为 -10 的字符串长度为 3.
    请你返回一个大小为 n 的整数数组 ans ，其中 ans[i] 是第 i 列的宽度.
    一个有 len 个数位的整数 x ，如果是非负数，那么字符串长度为 len ，否则为 len + 1.
 */
public class findColumnWidth_2639 {
    public int[] findColumnWidth(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] res = new int[m];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = grid[i][j];
                int len = 0;
                if (num <= 0) {
                    len = 1;
                }
                while (num != 0) {
                    len++;
                    num /= 10;
                }
                res[j] = Math.max(res[j], len);
            }
        }
        return res;
    }
}
