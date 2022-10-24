package October_2022;

import java.util.ArrayList;
import java.util.List;

/*
    给定两个整数 n 和 k, 返回范围 [1, n] 中所有可能的 k 个数的组合.
    你可以按任何顺序返回答案.
 */
public class combine_77 {
    //本质: 树的构造
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        getCombine(n, k, 1, new ArrayList<>());
        return res;
    }

    public void getCombine(int n, int k, int start, List<Integer> list){
        if(k == 0){
            //如果为 0 则代表 list 中已经存入 k 个数, 将 list 拷贝入结果 res 中
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= n - k + 1; i++){
            list.add(i);
            getCombine(n, k - 1, i + 1, list);
            //回溯操作(回退处理结点[1, 2]撤销 2, [1, 3]撤销 3)
            list.remove(list.size() - 1);
        }
    }
}
