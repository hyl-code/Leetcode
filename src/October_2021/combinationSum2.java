package October_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给定一个数组 candidates 和一个目标数 target,
    找出 candidates 中所有可以使数字和为 target 的组合 .
    candidates 中的每个数字在每个组合中只能使用一次 .
    注意: 解集不能包含重复的组合 .
 */

public class combinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        search(candidates, target, 0);
        return res;
    }

    public void search(int[] candidates, int target, int num){
        List<Integer> temp = new ArrayList<>(list);
        if(target == 0){
            res.add(temp);
            return;
        }
        for(int i = num; i < candidates.length; i++){
            if(candidates[i] <= target){
                if(i > num && candidates[i] == candidates[i-1]){
                    continue;
                }
                list.add(candidates[i]);
                search(candidates, target - candidates[i], i+1);
                list.remove(list.size() - 1);
            }
        }
    }
}
