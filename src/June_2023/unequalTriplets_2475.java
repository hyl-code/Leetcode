package June_2023;

import java.util.Arrays;

/*
    给你一个下标从 0 开始的正整数数组 nums. 请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
        0 <= i < j < k < nums.length
        nums[i]、nums[j] 和 nums[k] 两两不同.
        换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k].
    返回满足上述条件三元组的数目.
 */
public class unequalTriplets_2475 {
    //暴力枚举
    public int unequalTriplets(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    //排序
    public int unequalTriplets2(int[] nums) {
        Arrays.sort(nums);
        int res = 0, n = nums.length;
        for(int i = 0, j = 0; i < n; i = j){
            while(j < n && nums[j] == nums[i]){
                j++;
            }
            // i 表示左边元素数目, j - i 表示中间元素数目, n - j 表示右边元素数目.
            res += i * (j - i) * (n - j);
        }
        return res;
    }
}
