package April_2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    给你一个整数数组 nums, 返回 nums 中最长等差子序列的长度.
    回想一下, nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik],
    且 0 <= i1 < i2 < ... < ik <= nums.length - 1.
    并且如果 seq[i+1] - seq[i] (0 <= i < seq.length - 1)的值都相同, 那么序列 seq 是等差的.
 */
public class longestArithSeqLength_1027 {
    public int longestArithSeqLength(int[] nums) {
        int res = 0, n = nums.length;
        Map<Integer, Integer>[] f = new HashMap[n];
        Arrays.setAll(f, e -> new HashMap<>());
        for(int i = 1; i < n; i++){
            for(int j = i - 1; j >= 0; j--){
                int d = nums[i] - nums[j];
                // f 数组进行记忆化搜索
                if(!f[i].containsKey(d)){
                    f[i].put(d, f[j].getOrDefault(d, 1) + 1);
                    res = Math.max(res, f[i].get(d));
                }
            }
        }
        return res;
    }
}
