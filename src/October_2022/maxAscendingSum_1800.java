package October_2022;

/*
    给你一个正整数组成的数组 nums, 返回 nums 中一个 升序 子数组的最大可能元素和.
    子数组是数组中的一个连续数字序列.
    已知子数组 [numsl, numsl+1, ..., numsr-1, numsr], 若对所有 i(l <= i < r),
    nums[i] < nums[i+1] 都成立, 则称这一子数组为升序子数组.
    注意, 大小为 1 的子数组也视作升序子数组.
 */
public class maxAscendingSum_1800 {
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] > nums[i - 1]){
                sum += nums[i];
            }else{
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
