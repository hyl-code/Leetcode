package October_2023;

/*
    给你一个非空整数数组 nums, 除了某个元素只出现一次以外, 其余每个元素均出现两次. 找出那个只出现了一次的元素.
    你必须设计并实现线性时间复杂度的算法来解决此问题, 且该算法只使用常量额外空间.
 */
public class singleNumber_136 {
    // 任何数和其自身做异或运算，结果是 0 .
    public int singleNumber(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
