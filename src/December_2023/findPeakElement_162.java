package December_2023;

/*
    峰值元素是指其值严格大于左右相邻值的元素.
    给你一个整数数组 nums, 找到峰值元素并返回其索引. 数组可能包含多个峰值, 在这种情况下, 返回任何一个峰值所在位置即可.
    你可以假设 nums[-1] = nums[n] = -∞.
    你必须实现时间复杂度为 O(log n) 的算法来解决此问题.
 */
public class findPeakElement_162 {
    public int findPeakElement(int[] nums) {
        int idx = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[idx] < nums[i]){
                idx = i;
            }
        }
        return idx;
    }
}
