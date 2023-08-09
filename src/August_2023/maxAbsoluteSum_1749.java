package August_2023;

/*
    给你一个整数数组 nums.
    一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的和的绝对值为 abs(numsl + numsl+1 + ... + numsr-1 + numsr).
    请你找出 nums 中和的绝对值最大的任意子数组（可能为空）, 并返回该最大值.
    abs(x) 定义如下：
        如果 x 是负整数, 那么 abs(x) = -x.
        如果 x 是非负整数, 那么 abs(x) = x.
 */
public class maxAbsoluteSum_1749 {
    // 求最大值绝对值 = 求最值之差
    public int maxAbsoluteSum(int[] nums) {
        int max = 0;
        int min = 0;
        int sum = 0;
        for(int num : nums){
            sum += num;
            if(sum > max){
                max = sum;
            }else if(sum < min){
                min = sum;
            }
        }
        return max - min;
    }

    // 动态规划 + 分情况讨论
    public int maxAbsoluteSum2(int[] nums) {
        int posMax = 0, negMin = 0;
        int posSum = 0, negSum = 0;
        for(int num : nums){
            posSum += num;
            posMax = Math.max(posSum, posMax);
            posSum = Math.max(0, posSum);
            negSum += num;
            negMin = Math.min(negMin, negSum);
            negSum = Math.min(0, negSum);
        }
        return Math.max(posMax, -negMin);
    }
}
