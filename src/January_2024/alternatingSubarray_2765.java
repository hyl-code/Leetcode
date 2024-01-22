package January_2024;

/*
    给你一个下标从 0 开始的整数数组 nums. 如果 nums 中长度为 m 的子数组 s 满足以下条件, 我们称它是一个交替子数组 ：
        m 大于 1.
        s1 = s0 + 1.
        下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样.
        也就是说, s1 - s0 = 1, s2 - s1 = -1, s3 - s2 = 1, s4 - s3 = -1, 以此类推, 直到 s[m - 1] - s[m - 2] = (-1)m.
    请你返回 nums 中所有交替子数组中, 最长的长度, 如果不存在交替子数组, 请你返回 -1.
    子数组是一个数组中一段连续非空的元素序列.
 */
public class alternatingSubarray_2765 {
    public int alternatingSubarray(int[] nums) {
        int res = -1;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int len = j - i + 1;
                if(nums[j] - nums[i] == (len - 1) % 2){
                    res = Math.max(res, len);
                }else{
                    break;
                }
            }
        }
        return res;
    }
}
