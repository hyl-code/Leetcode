package October_2022;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个不含重复数字的数组 nums, 返回其所有可能的全排列.
    你可以按任意顺序返回答案.
 */
public class permute_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int num : nums){
            if(!list.contains(num)){
                list.add(num);
                backtrack(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
    /*
        回溯公式:
        result = []
        def backtrack(路径, 选择列表):
            if 满足结束条件:
                result.add(路径)
                return

            for 选择 in 选择列表:
                做选择
                backtrack(路径, 选择列表)
                撤销选择
     */
}
