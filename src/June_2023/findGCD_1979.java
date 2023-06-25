package June_2023;

import java.util.Arrays;
/*
    给你一个整数数组 nums, 返回数组中最大数和最小数的最大公约数.
    两个数的最大公约数是能够被两个数整除的最大正整数.
 */
public class findGCD_1979 {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0], b = nums[nums.length - 1];
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
