package June_2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid, 返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目.
    如果行和列以相同的顺序包含相同的元素（即相等的数组, 则认为二者是相等的.
 */
public class equalPairs_2352 {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int res = 0;
        //用 List 表示数组
        Map<List<Integer>, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            List<Integer> arr = new ArrayList<Integer>();
            for(int j = 0; j < n; j++){
                arr.add(grid[i][j]);
            }
            map.put(arr, map.getOrDefault(arr, 0) + 1);
        }
        for(int i = 0; i < n; i++){
            List<Integer> arr = new ArrayList<Integer>();
            for(int j = 0; j < n; j++){
                arr.add(grid[j][i]);
            }
            if(map.containsKey(arr)){
                res += map.get(arr);
            }
        }
        return res;
    }
}
