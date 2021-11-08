package October_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给定一个无重复元素的正整数数组 candidates 和一个正整数 target ,
    找出 candidates 中所有可以使数字和为目标数 target 的唯一组合 .
    candidates 中的数字可以无限制重复被选取. 如果至少一个所选数字数量不同, 则两种组合是唯一的 .
    对于给定的输入, 保证和为 target 的唯一组合数少于 150 个 .
 */

public class combinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        search(res, list, candidates, target, 0);
        return res;
    }

    public void search(List<List<Integer>> res, List<Integer> list, int candidates[], int target, int num){
        if(target == 0){
            res.add(list);
            return;
        }
        if(target < candidates[num]){
            return;
        }
        for(int i = num; i < candidates.length; i++){
            List<Integer> temp = new ArrayList<>(list);//list(原temp)元素放入现temp中
            temp.add(candidates[i]);
            search(res, temp, candidates, target - candidates[i], i);
        }
    }
}
