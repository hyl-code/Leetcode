package July_2022;

import java.util.Arrays;

/*
    给你一个大小为 m * n 的矩阵 mat, 矩阵由若干军人和平民组成, 分别用 1 和 0 表示 .

    请你返回矩阵中战斗力最弱的 k 行的索引, 按从最弱到最强排序 .

    如果第 i 行的军人数量少于第 j 行, 或者两行军人数量相同但 i 小于 j, 那么我们认为第 i 行的战斗力比第 j 行弱 .

    军人总是排在一行中的靠前位置, 也就是说 1 总是出现在 0 之前 .
 */

public class kWeakestRows_1337 {
    //统计
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        int[][] count = new int[n][2];
        for(int i = 0; i < n; i++){
            count[i][1] = i;
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0)
                    break;
                count[i][0]++;
            }
        }
        Arrays.sort(count, (a, b)->(a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = count[i][1];
        }
        return res;
    }
}
