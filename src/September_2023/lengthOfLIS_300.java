package September_2023;

/*
    给你一个整数数组 nums, 找到其中最长严格递增子序列的长度.
    子序列是由数组派生而来的序列, 删除（或不删除）数组中的元素而不改变其余元素的顺序.
    例如, [3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列.
 */
public class lengthOfLIS_300 {
    private int[] memo;

    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int n = nums.length;
        memo = new int[n];
        for(int i = 0; i < n; i++){
            res = Math.max(res, dfs(nums, i));
        }
        return res;
    }

    //记忆化搜索
    public int dfs(int[] nums, int i){
        if(memo[i] > 0){
            return memo[i];
        }
        for(int j = 0; j < i; j++){
            if(nums[j] < nums[i]){
                memo[i] = Math.max(memo[i], dfs(nums, j));
            }
        }
        return ++memo[i];
    }
}
