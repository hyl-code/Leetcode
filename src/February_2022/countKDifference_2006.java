package February_2022;

/*
    给你一个整数数组 nums 和一个整数 k, 请你返回数对(i, j)的数目,
    满足 i < j 且 |nums[i] - nums[j]| == k.
    |x|的值定义为:
    如果 x >= 0, 那么值为x.
    如果 x < 0, 那么值为-x.
 */

public class countKDifference_2006 {
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(Math.abs(nums[i] - nums[j]) == k){
                    res++;
                }
            }
        }
        return res;
    }
}
