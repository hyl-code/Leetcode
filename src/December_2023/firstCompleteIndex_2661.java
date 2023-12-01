package December_2023;

import java.util.HashMap;
import java.util.Map;
/*
    给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数矩阵 mat. arr 和 mat 都包含范围 [1，m * n] 内的所有整数.
    从下标 0 开始遍历 arr 中的每个下标 i, 并将包含整数 arr[i] 的 mat 单元格涂色.
    请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素, 并返回其下标 i.
 */
public class firstCompleteIndex_2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] rowCnt = new int[n];
        int[] colCnt = new int[m];
        for(int i = 0; i < arr.length; i++){
            int[] v = map.get(arr[i]);
            ++rowCnt[v[0]];
            if(rowCnt[v[0]] == m){
                return i;
            }
            ++colCnt[v[1]];
            if(colCnt[v[1]] == n){
                return i;
            }
        }
        return -1;
    }
}
