package October_2021;

/*
    给定一个整数数组和一个整数 k, 判断数组中是否存在两个不同的索引 i 和 j,
    使得 nums [i] = nums [j],并且 i 和 j 的差的绝对值至多为k.
 */

public class containsNearbyDuplicate_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length < 2)
            return false;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j <= i + k && j < nums.length; j++){
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}
