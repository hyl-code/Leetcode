package November_2023;

import java.util.Arrays;
import java.util.HashMap;
/*
    给你一个下标从 0 开始的数组 nums, 数组中的元素都是正整数.
    请你选出两个下标 i 和 j（i != j）, 且 nums[i] 的数位和与 nums[j] 的数位和相等.
    请你找出所有满足条件的下标 i 和 j, 找出并返回 nums[i] + nums[j] 可以得到的最大值.
 */
public class maximumSum_2342 {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int res = -1;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = n - 1; i >= 0; i--){
            int bitsum = 0, t = nums[i];
            while(t > 0){
                bitsum += (t % 10);
                t /= 10;
            }
            if(map.containsKey(bitsum)){
                res = Math.max(res, nums[i] + map.get(bitsum));
            }else{
                map.put(bitsum, nums[i]);
            }
        }
        return res;
    }
}
