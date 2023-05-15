package May_2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    给定 m x n 矩阵 matrix.
    你可以从中选出任意数量的列并翻转其上的每个单元格.（即翻转后, 单元格的值从 0 变成 1, 或者从 1 变为 0. ）
    返回经过一些翻转后, 行与行之间所有值都相等的最大行数.
 */
public class maxEqualRowsAfterFlips_1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int res = 0;
        for(int i = 0; i < matrix.length; i++){
            char[] arr = new char[matrix[0].length];
            Arrays.fill(arr, '0');
            for(int j = 0; j < matrix[0].length; j++){
                //如果 matrix[i][0] 为 1, 则对该行元素进行翻转.
                arr[j] = (char)('0' + (matrix[i][j] ^ matrix[i][0]));
            }
            String str = new String(arr);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for(int value : map.values()){
            res = Math.max(res, value);
        }
        return res;
    }
}
