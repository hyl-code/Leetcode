package April_2022;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个非负索引 rowIndex, 返回「杨辉三角」的第 rowIndex 行 .
    在「杨辉三角」中, 每个数是它左上方和右上方的数的和 .
 */

public class getRow_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long num = 1;
        for(int i = 0; i <= rowIndex; i++){
            res.add((int)num);
            num = num * (rowIndex - i) / (i + 1);
        }
        return res;
    }
}
