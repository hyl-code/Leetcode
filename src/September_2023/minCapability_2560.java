package September_2023;

/*
    沿街有一排连续的房屋. 每间房屋内都藏有一定的现金. 现在有一位小偷计划从这些房屋中窃取现金.
    由于相邻的房屋装有相互连通的防盗系统, 所以小偷不会窃取相邻的房屋.
    小偷的窃取能力定义为他在窃取过程中能从单间房屋中窃取的最大金额.
    给你一个整数数组 nums 表示每间房屋存放的现金金额.
    形式上, 从左起第 i 间房屋中放有 nums[i] 美元.
    另给你一个整数 k, 表示窃贼将会窃取的最少房屋数. 小偷总能窃取至少 k 间房屋.
    返回小偷的最小窃取能力.
 */
public class minCapability_2560 {
    // 二分查找
    public int minCapability(int[] nums, int k) {
        int left = 0, right = 0;
        for(int num : nums){
            right = Math.max(right, num);
        }
        // 开区间
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            // 最大金额为 mid 时, 最多可以偷的房子数是否 >= k
            if(check(nums, k, mid)){
                right = mid;
            }else{
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int k, int mid) {
        int f0 = 0, f1 = 0;
        for (int num : nums) {
            if (num > mid) {
                f0 = f1;
            } else {
                int tmp = f1;
                f1 = f0 + 1;
                f0 = tmp;
            }
        }
        return f1 >= k;
    }
}
