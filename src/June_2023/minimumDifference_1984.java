package June_2023;

import java.util.Arrays;
/*
    给你一个 下标从 0 开始 的整数数组 nums, 其中 nums[i] 表示第 i 名学生的分数. 另给你一个整数 k.
    从数组中选出任意 k 名学生的分数, 使这 k 个分数间最高分和最低分的差值达到最小化.
    返回可能的最小差值.
 */
public class minimumDifference_1984 {
    public int minimumDifference(int[] nums, int k) {
        if(k == 1){
            return 0;
        }
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i <= nums.length - k; i++){
            res = Math.min(res, nums[i + k - 1] - nums[i]);
        }
        return res;
    }
}
