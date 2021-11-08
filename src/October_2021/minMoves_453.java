package October_2021;

import java.util.Arrays;

/*
    给你一个长度为 n 的整数数组, 每次操作将会使 n - 1 个元素增加 1 .
    返回让数组所有元素相等的最小操作次数.
    (n-1个元素增加1, 相当于1个元素减1.)
 */

public class minMoves_453 {
    public int minMoves1(int[] nums) {
        Arrays.sort(nums);
        int res = 0;

        for(int num : nums){
            res += num - nums[0];
        }
        return res;
    }

    public int minMoves2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int res = 0;

        for(int num : nums){
            min = Math.min(min, num);
        }
        for(int num : nums){
            res += num - min;
        }
        return res;
    }
}
