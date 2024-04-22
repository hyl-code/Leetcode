package April_2024;

import java.util.ArrayList;
import java.util.List;
/*
    找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
        只使用数字 1 到 9
        每个数字最多使用一次
    返回所有可能的有效组合的列表. 该列表不能包含相同的组合两次，组合可以以任何顺序返回.
 */
public class combinationSum3_216 {
    List<Integer> tmp = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int mask = 0; mask < (1 << 9); mask++) {
            if (check(mask, k, n)) {
                res.add(new ArrayList<Integer>(tmp));
            }
        }
        return res;
    }

    private boolean check(int mask, int k, int n) {
        tmp.clear();
        for (int i = 0; i < 9; i++) {
            if (((1 << i) & mask) != 0) {
                tmp.add(i + 1);
            }
        }
        if (tmp.size() != k) {
            return false;
        }
        int sum = 0;
        for (int num : tmp) {
            sum += num;
        }
        return sum == n;
    }
}
