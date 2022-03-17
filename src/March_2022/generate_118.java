package March_2022;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个非负整数 numRows, 生成「杨辉三角」的前 numRows 行 .
    在「杨辉三角」中, 每个数是它左上方和右上方的数的和 .
 */

public class generate_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] arr = new int[numRows][numRows];
        for(int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                list.add(arr[i][j]);
            }
            res.add(list);
        }
        return res;
    }
}
