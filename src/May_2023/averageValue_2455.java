package May_2023;

/*
    给你一个由正整数组成的整数数组 nums, 返回其中可被 3 整除的所有偶数的平均值.
    注意：n 个元素的平均值等于 n 个元素求和再除以 n, 结果向下取整到最接近的整数.
 */
public class averageValue_2455 {
    public int averageValue(int[] nums) {
        int n = 0, sum = 0;
        for(int num  : nums){
            if(num % 6 == 0){
                n++;
                sum += num;
            }
        }
        return n == 0 ? 0 : (int)sum / n;
    }
}
