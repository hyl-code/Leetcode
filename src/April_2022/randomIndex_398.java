package April_2022;

import java.util.Random;

/*
    给定一个可能含有重复元素的整数数组, 要求随机输出给定的数字的索引.
    您可以假设给定的数字一定存在于数组中 .

    注意:
    数组大小可能非常大. 使用太多额外空间的解决方案将不会通过测试.
 */

public class randomIndex_398 {
    int[] nums;
    Random rand;

    public randomIndex_398(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }

    public int pick(int target) {
        int res = 0;
        for(int i = 0, count = 0; i < nums.length; i++){
            if(nums[i] == target){
                count++;
                if(rand.nextInt(count) == 0){
                    res = i;
                }
            }
        }
        return res;
    }
}
