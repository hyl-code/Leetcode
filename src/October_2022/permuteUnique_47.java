package October_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给定一个可包含重复数字的序列 nums, 按任意顺序返回所有不重复的全排列.
 */
public class permuteUnique_47 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(list, nums, 0, visited);
        return res;
    }

    public void backtrack(List<Integer> list, int[] nums, int index, boolean[] visited){
        if(index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])){
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtrack(list, nums, index + 1, visited);
            //回溯
            visited[i] = false;
            list.remove(index);
        }
    }
}
