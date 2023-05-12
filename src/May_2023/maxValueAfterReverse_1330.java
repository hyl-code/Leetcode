package May_2023;

/*
    给你一个整数数组 nums.
     「数组值」定义为所有满足 0 <= i < nums.length - 1 的 |nums[i] - nums[i+1]| 的和.
    你可以选择给定数组的任意子数组, 并将该子数组翻转. 但你只能执行这个操作一次.
    请你找到可行的最大数组值.
 */
public class maxValueAfterReverse_1330 {
    //利用数学性质: (a + b) + ∣a − b∣ = 2 ⋅ max(a, b)
    //            (a + b) − ∣a − b∣ = 2 ⋅ min(a, b)
    //分情况讨论 (利用对称性可只分为三种情况)
    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length;
        int base = 0, d = 0;
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            int a = nums[i - 1], b = nums[i];
            base += Math.abs(a - b);
            //维护 min(a, b) 的最大值 mx, 以及 max(a, b) 的最小值 mn.
            mx = Math.max(mx, Math.min(a, b));
            mn = Math.min(mn, Math.max(a, b));
            //对于翻转范围在数组边界的情况(i = 0 或 j = n - 1), 枚举并更新 d 的最大值.
            d = Math.max(d, Math.max(Math.abs(nums[0] - b) - Math.abs(a - b),
                    Math.abs(nums[n - 1] - a) - Math.abs(a - b)));
        }
        return base + Math.max(d, 2 * (mx - mn));
    }
}
